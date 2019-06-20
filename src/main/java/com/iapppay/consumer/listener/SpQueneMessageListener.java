package com.iapppay.consumer.listener;


import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.iapppay.consumer.common.ApplicationConstants;
import com.iapppay.consumer.common.Constants;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.MessageFramework;
import com.iapppay.consumer.framework.entity.Msg;
import com.iapppay.consumer.framework.entity.MsgHeader;
import com.iapppay.consumer.redis.RedisApplicationConstants;
import com.iapppay.consumer.redis.RedisUtils;
import com.iapppay.consumer.utils.MessageUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: SpQueneMessageListener
 * @classDescription:监听消息队列中的信息
 * @author lishiqiang
 * @create_date: 2019年4月25日 上午10:39:23
 * @update_date:
 */
@Slf4j
public class SpQueneMessageListener implements MessageListener {

	@Autowired
	private MessageFramework messageFramework;

	@Autowired
	private RedisUtils redisUtils;

	@Override
	public void onMessage(Message message) {
		Object value = redisUtils.getSystemConf(RedisApplicationConstants.SP_CONSUMER_ISOPEN_KEY,
				RedisApplicationConstants.SP_CONSUMER_ISOPEN_DEAULTVALUE);
		if (!Constants.IS_OPEN.equals(value.toString())) {
			log.info("The mq consumer listening service is not enabled");
			return;
		}
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
						msg.setMsgHeader(JSON.parseObject(mapMessage.getObjectProperty(name).toString(), MsgHeader.class));
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
			messageFramework.processMessage(msg);
		} catch (JMSException e) {
			log.error("message format error:", e.getMessage(), e);
		} catch (ConsumerException ce) {
			log.error("message format error:", ce.getMessage(), ce);
		}
	}
}
