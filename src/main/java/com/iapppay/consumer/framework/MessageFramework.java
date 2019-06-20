package com.iapppay.consumer.framework;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.iapppay.consumer.common.ApplicationConstants;
import com.iapppay.consumer.common.ConsumerExceptionEnum;
import com.iapppay.consumer.common.FieldNames;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.entity.ConsumerEnum;
import com.iapppay.consumer.framework.entity.Msg;
import com.iapppay.consumer.framework.entity.MsgHeader;
import com.iapppay.consumer.framework.entity.NULL;
import com.iapppay.consumer.framework.entity.response.ResponseBody;
import com.iapppay.consumer.service.CommonService;
import com.iapppay.consumer.utils.CheckUtil;
import com.iapppay.consumer.utils.SequenceGeneratorUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @className: MessageFramework
 * @classDescription:处理信息并调用服务类
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午2:41:45
 * @update_date:
 */
@Component
@Slf4j
public class MessageFramework implements InitializingBean {

	@Autowired
	private ApplicationContext applicationContext;

	private static final Map<Class<?>, Class<?>> REQUEST_PARAM_CACHE = new ConcurrentHashMap<>();

	/**
	 * @param msg
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseBody processMessage(Msg reqmsg) throws ConsumerException {
		if (reqmsg == null) {
			throw ConsumerException.newInstance(ConsumerExceptionEnum.MESSAGE_NULL.code(),
					ConsumerExceptionEnum.MESSAGE_NULL.message());
		}
		Class<?> serviceClazz = null;
		Class<?> reqClazz = null;
		Map<String, Object> operatMap = new HashMap<>();
		MsgHeader msgHeader = reqmsg.getMsgHeader();
		String msgCode = msgHeader.getMsgCode();
		operatMap.put(FieldNames.OPERATYPE, msgHeader.getOptType());
		operatMap.put(FieldNames.MSGTYPE, msgHeader.getMsgType());
		operatMap.put(FieldNames.MSGNAME, msgHeader.getMsgName());
		operatMap.put(FieldNames.SEQUENCE, SequenceGeneratorUtils.generatorSequence());

		// 通过code获取到对应服务对象
		ConsumerEnum thisConsumerEnum = null;
		for (ConsumerEnum cmdEnum : ConsumerEnum.values()) {
			if (cmdEnum.getReqCode().equals(msgCode)) {
				thisConsumerEnum = cmdEnum;
				break;
			}
		}

		try {
			serviceClazz = Class.forName(thisConsumerEnum.getReqClass());
		} catch (ClassNotFoundException e1) {
			log.error(e1.getMessage(), e1);
		}

		if (serviceClazz == null) {
			throw ConsumerException.newInstance(ConsumerExceptionEnum.REQUEST_OBJECT.code(),
					ConsumerExceptionEnum.REQUEST_OBJECT.message());
		}

		Object response = null;
		ResponseBody responseBody = null;
		CommonService commonService = (CommonService) applicationContext.getBean(serviceClazz);
		if ((reqClazz = REQUEST_PARAM_CACHE.get(serviceClazz)) != null) {
			if (NULL.class.equals(reqClazz)) {
				response = commonService.service(null, operatMap);
			} else {
				List<?> paramList = JSON.parseArray(reqmsg.getMsgBody(), reqClazz);
				if (paramList != null && paramList.size() > 0) {
					for (Object object : paramList) {
						CheckUtil.check(object);
					}
					response = commonService.service(paramList, operatMap);
				} else {
					log.warn("The message body content is empty");
				}
			}

			// 响应内容
			if (response == null) {
				responseBody = new ResponseBody();
				responseBody.setRespCode(ConsumerExceptionEnum.SUCCESS.code());
				responseBody.setRespMessage(ConsumerExceptionEnum.SUCCESS.message());
			} else if (response instanceof ResponseBody) {
				responseBody = (ResponseBody) response;
			} else {
				log.error("The response object could not be processed");
			}
		}
		return responseBody;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, CommonService> commonService = applicationContext.getBeansOfType(CommonService.class);
		for (CommonService commonServiceEntry : commonService.values()) {
			Method[] declaredMethods = commonServiceEntry.getClass().getDeclaredMethods();
			for (Method method : declaredMethods) {
				Type[] type = method.getGenericParameterTypes();
				if (type[0] instanceof ParameterizedType) {
					ParameterizedType listGenericType = (ParameterizedType) type[0];
					Class<?> paramClass = null;
					if (ApplicationConstants.SERVICE_NAME.equals(method.getName()) && !Object.class
							.equals(paramClass = (Class<?>) listGenericType.getActualTypeArguments()[0])) {
						REQUEST_PARAM_CACHE.put(commonServiceEntry.getClass(), paramClass);
						break;
					}
				}
			}
		}
		log.info("the REQUEST_PARAM_CACHE is {}.", JSON.toJSONString(REQUEST_PARAM_CACHE, true));
	}
}
