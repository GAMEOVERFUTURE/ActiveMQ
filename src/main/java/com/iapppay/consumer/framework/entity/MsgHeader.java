package com.iapppay.consumer.framework.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @className: MsgHeader
 * @classDescription:报文头
 * @author lishiqiang
 * @create_date: 2019年4月24日 下午7:28:11
 * @update_date:
 */
@Data
public class MsgHeader implements Serializable {

	private static final long serialVersionUID = -4914943880189203888L;

	private String msgType;

	private String msgName;

	private String optType;

	private String msgCode;

}
