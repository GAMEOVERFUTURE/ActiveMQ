package com.iapppay.consumer.framework.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @className: MsgBody
 * @classDescription:报文体
 * @author lishiqiang
 * @create_date: 2019年4月24日 下午7:31:24
 * @update_date:
 */
 @Data
public class MsgBody implements Serializable {

	private static final long serialVersionUID = 6336235359121985331L;

	/**
	 * 请求唯一序列号
	 */
	private String sequence;

	/**
	 * 报文版本
	 */
	private String version;

	private String msgjson;

}
