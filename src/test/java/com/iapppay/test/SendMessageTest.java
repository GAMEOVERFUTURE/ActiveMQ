package com.iapppay.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.iapppay.consumer.framework.entity.Msg;
import com.iapppay.consumer.framework.entity.MsgHeader;
import com.iapppay.consumer.framework.entity.request.Userinfo;
import com.iapppay.consumer.service.SpQueneMessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class SendMessageTest {

	@Autowired
	private SpQueneMessageService spQueneMessageService;

	@Test
	public void test() throws Exception {
		Msg msg = new Msg();
		List<Userinfo> userList = new ArrayList<>();
		Userinfo userinfo = new Userinfo();
		userinfo.setUserid(10);
		userinfo.setLoginname("test");
		userinfo.setUsername("testusername");
		userinfo.setPassword("123456");
		userinfo.setStatus("A");

		Userinfo userinfo2 = new Userinfo();
		userinfo2.setUserid(11);
		userinfo2.setLoginname("test2");
		userinfo2.setUsername("testusername2");
		userinfo2.setPassword("123456");
		userinfo2.setStatus("A");
		MsgHeader msgHeader = new MsgHeader();
		msg.setMsgHeader(msgHeader);
		userList.add(userinfo);
		userList.add(userinfo2);
		msg.setMsgBody(JSON.toJSONString(userList));

		msgHeader.setMsgName("userinfo");
		msgHeader.setMsgType("table");
		msgHeader.setOptType("add");
		msgHeader.setMsgCode("10001");

		// msgBody.setMsgjson("jsonString");
		// msgBody.setSequence("111111");
		// msgBody.setVersion("1.0.1");
		// msg.setTest("sss");
		spQueneMessageService.sendMessage(msg);
	}

}
