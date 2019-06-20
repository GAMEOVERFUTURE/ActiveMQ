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
import com.iapppay.consumer.framework.entity.request.BankInfo;
import com.iapppay.consumer.service.SpQueneMessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class CpBankServiceTest {

	@Autowired
	private SpQueneMessageService spQueneMessageService;

	@Test
	public void cpBankService() throws Exception {
		Msg msg = new Msg();
		MsgHeader msgHeader = new MsgHeader();
		BankInfo bankInfo = new BankInfo();
		bankInfo.setAccountid("1000011");
		bankInfo.setAccountname("lsq测试修改");
		bankInfo.setBankname("招商银行修改");
		bankInfo.setCpid(1000011);
		List<BankInfo> bankInfoList = new ArrayList<>();
		bankInfoList.add(bankInfo);
		msg.setMsgBody(JSON.toJSONString(bankInfoList));
		msgHeader.setMsgName("cp_bank");
		msgHeader.setMsgType("table");
		msgHeader.setOptType("add");
		msgHeader.setMsgCode("1002");
		msg.setMsgHeader(msgHeader);
		spQueneMessageService.sendMessage(msg);
	}

}
