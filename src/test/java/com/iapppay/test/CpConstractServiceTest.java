package com.iapppay.test;

import java.math.BigDecimal;
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
import com.iapppay.consumer.framework.entity.request.ContractInfo;
import com.iapppay.consumer.framework.entity.request.CpAccoRulesInfo;
import com.iapppay.consumer.framework.entity.request.CpContractInfo;
import com.iapppay.consumer.framework.entity.request.CpPayChanInfo;
import com.iapppay.consumer.service.SpQueneMessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class CpConstractServiceTest {

	@Autowired
	private SpQueneMessageService spQueneMessageService;

	@Test
	public void test() throws Exception {
		Msg msg = new Msg();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setMsgName("cp_bank");
		msgHeader.setMsgType("table");
		msgHeader.setOptType("add");
		msgHeader.setMsgCode("1004");
		msg.setMsgHeader(msgHeader);

		ContractInfo contractInfo = new ContractInfo();
		CpContractInfo cpContractInfo = new CpContractInfo();
		List<CpAccoRulesInfo> rulesList = new ArrayList<>();
		List<CpPayChanInfo> payChanList = new ArrayList<>();
		CpAccoRulesInfo cpAccoRulesInfo = new CpAccoRulesInfo();
		CpAccoRulesInfo cpAccoRulesInfo2 = new CpAccoRulesInfo();
		rulesList.add(cpAccoRulesInfo2);
		rulesList.add(cpAccoRulesInfo);

		CpPayChanInfo cpPayChanInfo = new CpPayChanInfo();
		CpPayChanInfo cpPayChanInfo2 = new CpPayChanInfo();

		payChanList.add(cpPayChanInfo2);
		payChanList.add(cpPayChanInfo);

		cpContractInfo.setCpid(9888777);
		cpContractInfo.setIselecontract(1);

		cpAccoRulesInfo.setCpid(9888777);
		cpAccoRulesInfo.setEndval(new BigDecimal("1000"));
		cpAccoRulesInfo.setStartval(new BigDecimal("100"));
		cpAccoRulesInfo.setCprate(0.1);

		cpAccoRulesInfo2.setCpid(9888777);
		cpAccoRulesInfo2.setEndval(new BigDecimal("1000"));
		cpAccoRulesInfo2.setStartval(new BigDecimal("100"));
		cpAccoRulesInfo2.setCprate(0.2);

		cpPayChanInfo.setCpid(9888777);
		cpPayChanInfo.setPlatchanno(401000);
		cpPayChanInfo.setChanrate(0.6);
		cpPayChanInfo.setMinfee(0.3);

		cpPayChanInfo2.setCpid(9888777);
		cpPayChanInfo2.setPlatchanno(120000);
		cpPayChanInfo2.setChanrate(0.7);
		cpPayChanInfo2.setMinfee(0.3);

		contractInfo.setCpContractInfo(cpContractInfo);
		contractInfo.setPayChanList(payChanList);
		contractInfo.setRulesList(rulesList);

		List<ContractInfo> bankInfoList = new ArrayList<>();
		bankInfoList.add(contractInfo);
		msg.setMsgBody(JSON.toJSONString(bankInfoList));
		spQueneMessageService.sendMessage(msg);
	}

}
