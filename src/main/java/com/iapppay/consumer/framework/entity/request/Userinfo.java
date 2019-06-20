package com.iapppay.consumer.framework.entity.request;

import com.iapppay.consumer.framework.entity.MessageCheck;
import com.iapppay.consumer.framework.entity.OptionalEnum;

import lombok.Data;

/**
 * 
 * @className: Userinfo
 * @classDescription:接口对象
 * @author lishiqiang
 * @create_date: 2019年4月26日 上午11:34:36
 * @update_date:
 */
@Data
public class Userinfo {

	@MessageCheck(con = OptionalEnum.M)
	public Integer userid;

	@MessageCheck(con = OptionalEnum.M)
	public String loginname;

	@MessageCheck(con = OptionalEnum.O)
	public String password;

	@MessageCheck(con = OptionalEnum.O)
	public String status;

	public String username;
}