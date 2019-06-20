package com.iapppay.consumer.common;

/**
 * 
 * @className: BelongSystemEnum
 * @classDescription:归属方代码
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午10:24:51
 * @update_date:
 */
public enum BelongSystemEnum {

	/**
	 * 默认0
	 */
	DEFAULT(0),

	/**
	 * pay支付平台
	 */
	PAY_PLAT(1),

	/**
	 * 千百汇平台
	 */
	MARKET(2);

	private Integer value;

	BelongSystemEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
