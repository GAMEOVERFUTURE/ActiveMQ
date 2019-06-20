package com.iapppay.consumer.common;

/**
 * 
 * @className: WaresStatusEnum
 * @classDescription:应用状态枚举
 * @author lishiqiang
 * @create_date: 2019年5月15日 下午2:57:15
 * @update_date:
 */
public enum WaresStatusEnum {

	/**
	 * 正常
	 */
	NORMAL("A"),

	/**
	 * 暂停
	 */
	PAUSE("B"),

	/**
	 * 下线
	 */
	OFF_LINE("C"),

	/**
	 * 处罚
	 */
	PUNISH("P"),

	/**
	 * 未上架
	 */
	NOT_ON("T");

	private String value;

	WaresStatusEnum(String value) {
		this.value =value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
