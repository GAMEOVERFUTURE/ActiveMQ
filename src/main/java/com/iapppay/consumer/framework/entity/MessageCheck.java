package com.iapppay.consumer.framework.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @className: ConsumerCheck
 * @classDescription:
 * @author lishiqiang  
 * @create_date: 2019年4月26日 上午9:30:41 
 * @update_date:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MessageCheck {

	OptionalEnum con() default OptionalEnum.O;

	String regular() default "^.*$";

	String[] content() default {};
}
