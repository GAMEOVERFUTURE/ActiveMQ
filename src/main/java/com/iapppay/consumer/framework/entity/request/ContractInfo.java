package com.iapppay.consumer.framework.entity.request;

import java.util.List;

/**
 * 
 * @className: ContractInfo
 * @classDescription:合同请求对象
 * @author lishiqiang
 * @create_date: 2019年5月7日 下午3:15:06
 * @update_date:
 */
public class ContractInfo {

	public CpContractInfo cpContractInfo;

	public List<CpAccoRulesInfo> rulesList;

	public List<CpPayChanInfo> payChanList;

	public CpContractInfo getCpContractInfo() {
		return cpContractInfo;
	}

	public void setCpContractInfo(CpContractInfo cpContractInfo) {
		this.cpContractInfo = cpContractInfo;
	}

	public List<CpAccoRulesInfo> getRulesList() {
		return rulesList;
	}

	public void setRulesList(List<CpAccoRulesInfo> rulesList) {
		this.rulesList = rulesList;
	}

	public List<CpPayChanInfo> getPayChanList() {
		return payChanList;
	}

	public void setPayChanList(List<CpPayChanInfo> payChanList) {
		this.payChanList = payChanList;
	}

}
