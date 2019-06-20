package com.iapppay.consumer.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iapppay.consumer.common.ConsumerExceptionEnum;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.entity.MessageCheck;
import com.iapppay.consumer.framework.entity.OptionalEnum;
import com.iapppay.consumer.framework.entity.request.RequestBody;

/**
 * 
 * @className: CheckUtil
 * @classDescription:消息体校验工具类
 * @author lishiqiang
 * @create_date: 2019年4月26日 上午10:27:13
 * @update_date:
 */
public class CheckUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckUtil.class);

	public static void check(Object object) throws ConsumerException {
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();

		for (Field field : declaredFields) {
			Annotation[] annotations = field.getDeclaredAnnotations();
			Object fieldObject = null;
			try {
				fieldObject = field.get(object);
			} catch (IllegalArgumentException e) {
				throw new ConsumerException(ConsumerExceptionEnum.FIELD_ERROR.code(),
						"this field[" + field.getName() + "] format is not correct");

			} catch (IllegalAccessException e) {
				throw new ConsumerException(ConsumerExceptionEnum.FIELD_ERROR.code(),
						"this field[" + field.getName() + "] format is not correct");
			}

			checkObject(fieldObject);

			if (annotations.length > 0) {
				// 获取注解类型并判断
				for (Annotation annotation : annotations) {
					if (annotation instanceof MessageCheck) {
						MessageCheck messageCheck = (MessageCheck) annotation;
						// 判断是否必填
						if (OptionalEnum.M.equals(messageCheck.con())) {
							if(fieldObject ==null) {
								throw new ConsumerException(ConsumerExceptionEnum.FIELD_ERROR.code(),
										"this field[" + field.getName() + "] data is necessary");
							}
						}

						// 正则验证
						if (fieldObject != null && !String.valueOf(fieldObject).matches(messageCheck.regular())) {
							throw new ConsumerException(ConsumerExceptionEnum.FIELD_ERROR.code(),
									"this field[" + field.getName() + "] data format not correct");
						}

						if (messageCheck.content().length > 0) {
							String[] content = messageCheck.content();
							boolean isExist = ArrayUtils.contains(content, fieldObject);
							if (!isExist)
								throw new ConsumerException(ConsumerExceptionEnum.FIELD_ERROR.code(),
										"this field[" + field.getName() + "] data is not correct");
						}
					}else {
						LOGGER.info("the annotation[{}] undisposed", annotation);
					}
				}
			}
		}
    }

	/**
	 * 针对特殊场景做处理
	 * 
	 * @param fieldObject
	 * @throws ConsumerException
	 */
	@SuppressWarnings("rawtypes")
	private static void checkObject(Object fieldObject) throws ConsumerException {
		// 处理对象中的特殊场景
		if (fieldObject instanceof List) {
			for (Object fieldObjectSec : (List) fieldObject) {
				if (fieldObject instanceof RequestBody) {
					check(fieldObjectSec);
				}
			}
		} else if (fieldObject instanceof RequestBody) {
			check(fieldObject);
		}
	}
}
