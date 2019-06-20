package com.iapppay.consumer.framework.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @className: Msg
 * @classDescription:报文对象
 * @author lishiqiang
 * @create_date: 2019年4月24日 下午7:27:12
 * @update_date:
 */
@Data
public class Msg implements Serializable {

	private static final long serialVersionUID = -4775324542566270454L;

	/**
	 * 报文头
	 */
	private MsgHeader msgHeader;

	/**
	 * 报文体
	 */
	private String msgBody;
}
