package com.iapppay.consumer.service;

import java.util.List;
import java.util.Map;

import com.iapppay.consumer.exception.ConsumerException;

/**
 * 
 * @className: CommonService
 * @classDescription:公共服务类
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午1:54:25
 * @update_date:
 */
public interface CommonService<R, P> {
	public R service(List<P> param, Map<String, Object> operat) throws ConsumerException;
}
