package com.iapppay.consumer.service.Impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.iapppay.consumer.framework.entity.Msg;
import com.iapppay.consumer.service.SpQueneMessageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SpQueneMessageServiceImpl implements SpQueneMessageService {


	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	// 目的地队列的明证，我们要向这个队列发送消息
	@Resource(name = "destinationQueue")
	private Destination destination;

	@Override
	public void sendMessage(Msg msg) throws Exception {
		final String messageBody = msg.getMsgBody();
		final String messageHeader = JSON.toJSONString(msg.getMsgHeader());
		try {
			log.info("将要向队列{}发送的消息msg:{}", destination, messageBody);
			// System.out.println("将要向队列{" + destination + "}发送的消息msg:{" + message + "}");
			jmsTemplate.send(destination, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					// TextMessage mapMessage = session.createTextMessage();
					MapMessage mapmessage = session.createMapMessage();
					mapmessage.setObjectProperty("msgHeader", messageHeader);
					mapmessage.setObjectProperty("msgBody", messageBody);
					// mapMessage.setText(JSON.toJSONString(msgessage));
					return mapmessage;
				}
			});

		} catch (Exception ex) {
			log.error("向队列{}发送消息失败，消息为：{}", destination, msg);
		}
	}

}
