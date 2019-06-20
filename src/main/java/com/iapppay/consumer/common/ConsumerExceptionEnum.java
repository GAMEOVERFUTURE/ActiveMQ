package com.iapppay.consumer.common;

/**
 * 
 * @className: ConsumerExceptionEnum
 * @classDescription:异常枚举
 * @author lishiqiang
 * @create_date: 2019年5月17日 上午10:55:00
 * @update_date:
 * @D 10000 --- 30000 field error
 * @D 30000 --- 66666 business error
 * @D 66666 --- 99999 system error
 */
public enum ConsumerExceptionEnum {


	/**
	 * 业务和系统处理成功
	 */
	SUCCESS("00000", "Handle a successful"),

	FIELD_ERROR("10000", "field value is not correct"),

	MSG_OPTTYPE_ERROR("10010", "optType Undefined"),

	MSG_CODE_ERROR("10020", "msgCode Undefined"),

	MSG_HEADER_ERROR("10030", "msgHeader not correct"),

	MESSAGE_NULL("30000", "mq message is null"),

	// magic boundary------- business error

	REQUEST_OBJECT("30010", "request object is null"),

	DSWARES_EXIST("30020", "dsWares already exist"),

	DSWARES_NULL("30030", "dswares is null"),

	CP_ID_NULL("30040", "cpId is null"),

	CP_BANK_EXIST("30050", "dsCpBank already exist"),

	CP_BANK_NOT_EXIST("30060", "dsCpBank or yqzlCpPayInfo is null"),

	/**
	 * 数据层面处理失败
	 */
	MYSQL_ERROR("66656", "mysql insert error"),

	/**
	 * 业务处理失败默认异常
	 */
	BUSINESS_ERROR("66666", "Business processing failure"),

	// magic boundary------ system error

	DSWARES_INSERT_ERROR("66676", "dswares insert error!"),

	DSWARES_UPDATE_ERROR("66686", "dswares update error!"),

	/**
	 * 系统出现未知异常
	 */
	SYSTEM_ERROR("99999", "system error");

	ConsumerExceptionEnum() {
	}

	private ConsumerExceptionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	private String code;
	private String message;

	public String code() {
		return code;
	}

	public String message() {
		return message;
	}

	public void message(String message) {
		this.message = message;
	}

}
