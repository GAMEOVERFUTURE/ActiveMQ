package com.iapppay.consumer.framework.entity.response;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @className: ResponseBody
 * @classDescription:响应对象
 * @author lishiqiang
 * @create_date: 2019年5月16日 下午5:24:36
 * @update_date:
 */
@Data
public class ResponseBody implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应码
	 */
	private String respCode;

	/**
	 * 响应信息
	 */
	private String respMessage;

	/**
	 * 系统响应码
	 */
	private String sysRespCode;

	/**
	 * 系统响应信息
	 */
	private String sysRespMessage;
}
