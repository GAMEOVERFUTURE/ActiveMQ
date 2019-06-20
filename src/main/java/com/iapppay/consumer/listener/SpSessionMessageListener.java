package com.iapppay.consumer.listener;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSON;
import com.iapppay.consumer.common.ApplicationConstants;
import com.iapppay.consumer.common.Constants;
import com.iapppay.consumer.common.ConsumerExceptionEnum;
import com.iapppay.consumer.framework.MessageFramework;
import com.iapppay.consumer.framework.entity.Msg;
import com.iapppay.consumer.framework.entity.MsgHeader;
import com.iapppay.consumer.framework.entity.response.ResponseBody;
import com.iapppay.consumer.redis.RedisApplicationConstants;
import com.iapppay.consumer.redis.RedisUtils;
import com.iapppay.consumer.utils.MessageUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: SpSessionMessageListener
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年5月17日 上午10:18:07
 * @update_date:
 */
@Slf4j
public class SpSessionMessageListener implements SessionAwareMessageListener<Message> {

	@Autowired
	private MessageFramework messageFramework;

	@Autowired
	private RedisUtils redisUtils;

	// 目的地队列的明证，我们要向这个队列发送消息
	@Resource(name = "responsedestinationQueue")
	private Destination destination;

	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		Object value = redisUtils.getSystemConf(RedisApplicationConstants.SP_CONSUMER_ISOPEN_KEY,
				RedisApplicationConstants.SP_CONSUMER_ISOPEN_DEAULTVALUE);
		if (!Constants.IS_OPEN.equals(value.toString())) {
			log.info("The mq consumer listening service is not enabled");
			return;
		}

		ResponseBody responseBody = null;
		String messageString = null;
		Msg msg = null;
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMsg = (TextMessage) message;
				messageString = txtMsg.getText();
				msg = JSON.parseObject(messageString, Msg.class);
			} else if (message instanceof MapMessage) {
				MapMessage mapMessage = (MapMessage) message;
				Enumeration<?> enumeration = mapMessage.getPropertyNames();
				msg = new Msg();
				while (enumeration.hasMoreElements()) {
					String name = (String) enumeration.nextElement();
					if (ApplicationConstants.MSGHEADER.equals(name)) {
						msg.setMsgHeader(
								JSON.parseObject(mapMessage.getObjectProperty(name).toString(), MsgHeader.class));
					}
					if (ApplicationConstants.MSGBODY.equals(name)) {
						msg.setMsgBody(mapMessage.getObjectProperty(name).toString());
					}
				}
				messageString = JSON.toJSONString(msg);
			} else if (message instanceof ObjectMessage) {
				ObjectMessage objectMsg = (ObjectMessage) message;
				messageString = (String) objectMsg.getObject();
				msg = JSON.parseObject(messageString, Msg.class);
			} else {
				log.warn("The system could not process this message[{}] ", message.getJMSType());
				return;
			}

			// 判断消息是否符合格式规范
			MessageUtils.checkMessage(msg);
			log.info("message content--->{}", messageString);
			responseBody = messageFramework.processMessage(msg);
			responseBody.setSysRespCode(ConsumerExceptionEnum.SUCCESS.code());
			responseBody.setSysRespMessage(ConsumerExceptionEnum.SUCCESS.message());
		} catch (Exception e) {
			responseBody = new ResponseBody();
			responseBody.setSysRespCode(ConsumerExceptionEnum.SYSTEM_ERROR.code());
			responseBody.setSysRespMessage(ConsumerExceptionEnum.SYSTEM_ERROR.message() + "--->" + e.getMessage().substring(128));
			log.error("message handler error:", e.getMessage(), e);
		}

		// 响应
		Msg responseMsg = processResponseMessage(msg.getMsgHeader(), responseBody);
		MessageProducer messageProducer = session.createProducer(destination);
		TextMessage textMessage = session.createTextMessage();
		textMessage.setText(JSON.toJSONString(responseMsg));
		log.info("reponse message ---->{}", JSON.toJSONString(responseMsg));
		messageProducer.send(textMessage);
	}

	/**
	 * 组装响应对象
	 * 
	 * @param msgHeader
	 * @param responseBody
	 * @return
	 */
	private Msg processResponseMessage(MsgHeader msgHeader, ResponseBody responseBody) {
		Msg msg = new Msg();
		msg.setMsgHeader(msgHeader);
		msg.setMsgBody(JSON.toJSONString(responseBody));
		return msg;
	}

}
