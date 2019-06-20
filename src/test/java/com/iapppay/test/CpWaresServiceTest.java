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
import com.iapppay.consumer.framework.entity.request.CpWaresInfo;
import com.iapppay.consumer.framework.entity.request.CpWaresInfo.DistRule;
import com.iapppay.consumer.service.SpQueneMessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class CpWaresServiceTest {

	@Autowired
	private SpQueneMessageService spQueneMessageService;

	// @Test
	public void test() throws Exception {
		Msg msg = new Msg();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setMsgName("cp_wares");
		msgHeader.setMsgType("table");
		msgHeader.setOptType("update");
		msgHeader.setMsgCode("1005");
		msg.setMsgHeader(msgHeader);

		CpWaresInfo cpWaresInfo = new CpWaresInfo();
		cpWaresInfo.setWaresid("666002075");
		cpWaresInfo.setWaresstatus("C");
		cpWaresInfo.setWaresname("商户名称");
		cpWaresInfo.setCpid(111);
		cpWaresInfo.setCacheflag(1);
		List<CpWaresInfo> s = new ArrayList<>();
		s.add(cpWaresInfo);
		msg.setMsgBody(JSON.toJSONString(s));
		spQueneMessageService.sendMessage(msg);
	}

	// @Test
	public void test2() throws Exception {
		Msg msg = new Msg();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setMsgName("cp_wares");
		msgHeader.setMsgType("table");
		msgHeader.setOptType("add");
		msgHeader.setMsgCode("1005");
		msg.setMsgHeader(msgHeader);

		CpWaresInfo cpWaresInfo = new CpWaresInfo();
		cpWaresInfo.setWaresid("123456789");
		cpWaresInfo.setWaresstatus("A");
		cpWaresInfo.setWaresname("lsq商户名称");
		cpWaresInfo.setCpid(111);
		cpWaresInfo.setCacheflag(1);
		cpWaresInfo.setVia(1);
		List<CpWaresInfo> s = new ArrayList<>();
		s.add(cpWaresInfo);
		msg.setMsgBody(JSON.toJSONString(s));
		spQueneMessageService.sendMessage(msg);
	}

	@Test
	public void test3() throws Exception {
		Msg msg = new Msg();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setMsgName("cp_wares");
		msgHeader.setMsgType("table");
		msgHeader.setOptType("transfer");
		msgHeader.setMsgCode("1005");
		msg.setMsgHeader(msgHeader);

		CpWaresInfo cpWaresInfo = new CpWaresInfo();
		cpWaresInfo.setWaresid("123456789");
		cpWaresInfo.setWaresstatus("A");
		cpWaresInfo.setWaresname("lsq商户名称sss");
		cpWaresInfo.setCpid(111);
		cpWaresInfo.setCacheflag(1);
		cpWaresInfo.setVia(1);
		List<DistRule> distrules = new ArrayList<>();
		CpWaresInfo.DistRule distrule1 = cpWaresInfo.new DistRule();
		CpWaresInfo.DistRule distrule2 = cpWaresInfo.new DistRule();
		distrule1.setAcid(65555);
		distrule1.setAppid("123456789");
		distrule1.setCpid(111);
		distrule1.setDistrate(20.0);
		distrule1.setPlatid(10000);

		distrule2.setAcid(65555);
		distrule2.setAppid("123456789");
		distrule2.setCpid(112);
		distrule2.setDistrate(80.0);
		distrule2.setPlatid(10000);
		distrules.add(distrule1);
		distrules.add(distrule2);
		cpWaresInfo.setDistrules(distrules);
		List<CpWaresInfo> s = new ArrayList<>();
		s.add(cpWaresInfo);
		msg.setMsgBody(JSON.toJSONString(s));
		spQueneMessageService.sendMessage(msg);
	}

}
