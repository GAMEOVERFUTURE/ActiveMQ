package com.iapppay.consumer.exception;

import com.iapppay.consumer.common.ConsumerExceptionEnum;

/**
 * 
 * @className: ConsumerException
 * @classDescription:异常类
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午7:24:03
 * @update_date:
 */
public class ConsumerException extends Exception {

	private static final long serialVersionUID = -1835545066605207394L;

	private String code;
	private String message;

	public static ConsumerException newInstance(String code, String message) {
		return new ConsumerException(code, message);
	}

	public static ConsumerException newInstance(String message) {
		return new ConsumerException(message);
	}

	public static ConsumerException newInstance(ConsumerExceptionEnum exceptionEnum) {
		return new ConsumerException(exceptionEnum.code(), exceptionEnum.message());
	}

	public ConsumerException(String message) {
		super(message);
		this.message = message;
	}

	public ConsumerException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
