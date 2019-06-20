/**
 * 
 */
package com.iapppay.consumer.listener;

import java.util.Enumeration;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * tableQueue队列消息监听器
 * 
 * @author linhangwu
 * @date 2019年4月18日
 * 
 */
@Component
public class TableQueueMessageListener implements SessionAwareMessageListener<MapMessage> {

    @Override
	public void onMessage(MapMessage message, Session session) throws JMSException {
        
        StringBuffer buffer = new StringBuffer();
        
        Enumeration<String> enumeration =  message.getPropertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = message.getStringProperty(key);
            
            buffer.append(key).append("：").append(value).append("  ");
        }
        
        System.out.println(">>>>>收到消息：" + buffer.toString());
    }
}
