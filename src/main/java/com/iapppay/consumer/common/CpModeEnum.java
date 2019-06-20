package com.iapppay.consumer.common;

/**
 * 
 * @className: CpModeEnum
 * @classDescription:计费模式
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午10:44:39
 * @update_date:
 */
public enum CpModeEnum {

	/**
	 * 销售净收入
	 */
	NET_SALES("1"),

	/**
	 * 交易流水
	 */
	TRANS_RECORED("2");

	private String value;

	CpModeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
