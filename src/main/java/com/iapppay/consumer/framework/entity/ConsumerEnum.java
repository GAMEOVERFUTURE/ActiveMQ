package com.iapppay.consumer.framework.entity;

/**
 * 
 * @className: ConsumerEnum
 * @classDescription:所有消费对象枚举
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午3:03:39
 * @update_date:
 */
public enum ConsumerEnum {

	USERINFO("com.iapppay.consumer.service.Impl.UserServiceImpl", "1001"),
	CPBANKINFO("com.iapppay.consumer.service.Impl.CpBankServiceImpl", "1002"),
	CPBASEINFO("com.iapppay.consumer.service.Impl.CpBaseServiceImpl", "1003"),
	CPCONSTRACT("com.iapppay.consumer.service.Impl.CpContractServiceImpl","1004"),
	CPWARES("com.iapppay.consumer.service.Impl.CpWaresServiceImpl","1005");
	
	ConsumerEnum(String reqClass, String reqCode) {
		this.reqClass = reqClass;
		this.reqCode = reqCode;
	}

	public String reqClass;

	public String reqCode;

	public String getReqClass() {
		return reqClass;
	}

	public void setReqClass(String reqClass) {
		this.reqClass = reqClass;
	}

	public String getReqCode() {
		return reqCode;
	}

	public void setReqCode(String reqCode) {
		this.reqCode = reqCode;
	}

}
