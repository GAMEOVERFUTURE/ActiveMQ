package com.iapppay.consumer.common;

import java.math.BigDecimal;

/**
 * 
 * @className: Constants
 * @classDescription:常量
 * @author lishiqiang
 * @create_date: 2019年4月24日 下午3:43:01
 * @update_date:
 */
public class Constants {

	/**
	 * 银行标识默认值
	 */
	public static final String BANK_FLAG_DEFAULT = "0";

	/**
	 * 地区标识默认值
	 */
	public static final String AREA_FLAG_DEFAULT = "0";

	/**
	 * 最后更新操作人默认值
	 */
	public static final int UPDATE_BY_DEFAULT = 0;

	/**
	 * 月结
	 */
	public static final String BALACYCTYPE_MONTH = "10";

	/**
	 * 周结
	 */
	public static final String BALACYCTYPE_WEEK = "11";

	/**
	 * T+X结
	 */
	public static final String BALACYCTYPE_DAY = "12";

	public static final int MULTIPLY_PARAM = 100;

	public static final String IS_OPEN = "Y";

	public static final double DEFUALT_DOUBLE_DISTRATE = 100;

	public static final BigDecimal DEFUALT_DISTRATE = new BigDecimal("100");

	public static final String RULE_STATUS_Y = "Y";
}
