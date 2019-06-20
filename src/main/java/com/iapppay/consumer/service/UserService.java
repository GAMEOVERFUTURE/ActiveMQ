package com.iapppay.consumer.service;

import com.iapppay.consumer.framework.entity.request.Userinfo;

/**
 * 
 * @className: UserService
 * @classDescription:用户服务接口
 * @author lishiqiang
 * @create_date: 2019年4月24日 下午3:52:05
 * @update_date:
 */
public interface UserService {

	public void request(Userinfo userInfo) throws Exception;
}
