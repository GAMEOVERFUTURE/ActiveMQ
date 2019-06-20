package com.iapppay.consumer.common;

/**
 * 
 * @className: ServiceTypeEnum
 * @classDescription:服务类型
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午10:31:01
 * @update_date:
 */
public enum ServiceTypeEnum {

	/**
	 * 计费服务
	 */
	CHARGE_SERVE("10"),

	/**
	 * 计费委托结算
	 */
	CHARGE_SETTLEMENT("11"),

	/**
	 * 代理合作
	 */
	PROXY_TEAMWORK("12"),

	/**
	 * 渠道推广
	 */
	CHANNEL_POP("13"),

	/**
	 * 标准ODM
	 */
	STANDARD_ODM("14");

	private String value;

	ServiceTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
