package com.iapppay.consumer.utils;

import org.apache.commons.lang3.StringUtils;

import com.iapppay.consumer.common.ConsumerExceptionEnum;
import com.iapppay.consumer.common.DbOperatTypeEnum;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.entity.ConsumerEnum;
import com.iapppay.consumer.framework.entity.Msg;
import com.iapppay.consumer.framework.entity.MsgHeader;

/**
 * 
 * @className: MessageUtils
 * @classDescription:信息体工具类
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午1:41:50
 * @update_date:
 */
public class MessageUtils {

	/**
	 * 处理消息
	 */
	public static void checkMessage(Msg msg) throws ConsumerException {
		// 校验信息头
		if (msg == null) {
			throw ConsumerException.newInstance(ConsumerExceptionEnum.MSG_HEADER_ERROR.code(),
					"msg is null,not correct");
		}
		MsgHeader msgHeader = msg.getMsgHeader();
		String msgCode = msgHeader.getMsgCode();
		String optType = msgHeader.getOptType();

		if (StringUtils.isBlank(msgCode) || StringUtils.isBlank(optType)) {
			throw ConsumerException.newInstance(ConsumerExceptionEnum.MSG_HEADER_ERROR.code(),
					"msgHeader-->msgCode[" + msgCode + "],optType[" + optType + "] not correct");
		}

		ConsumerEnum thisConsumerEnum = null;
		for (ConsumerEnum cmdEnum : ConsumerEnum.values()) {
			if (cmdEnum.getReqCode().equals(msgCode)) {
				thisConsumerEnum = cmdEnum;
				break;
			}
		}

		if (thisConsumerEnum == null) {
			throw ConsumerException.newInstance(ConsumerExceptionEnum.MSG_CODE_ERROR.code(),
					"msgCode[" + msgCode + "] undefined");
		}

		boolean checkOptType = DbOperatTypeEnum.checkType(optType);
		if (!checkOptType) {
			throw ConsumerException.newInstance(ConsumerExceptionEnum.MSG_OPTTYPE_ERROR.code(),
					"optType[" + msgCode + "] undefined");
		}

	}
}
