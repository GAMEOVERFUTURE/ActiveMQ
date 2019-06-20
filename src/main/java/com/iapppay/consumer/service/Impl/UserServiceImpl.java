package com.iapppay.consumer.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iapppay.consumer.common.DbOperatTypeEnum;
import com.iapppay.consumer.common.FieldNames;
import com.iapppay.consumer.dao.UserinfoMapper;
import com.iapppay.consumer.exception.ConsumerException;
import com.iapppay.consumer.framework.entity.NULL;
import com.iapppay.consumer.framework.entity.request.Userinfo;
import com.iapppay.consumer.service.CommonService;

/**
 * 
 * @className: UserServiceImpl2
 * @classDescription:用户服务类实现
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午5:48:15
 * @update_date:
 */
@Service
public class UserServiceImpl implements CommonService<NULL, Userinfo> {

	@Autowired
	private UserinfoMapper userinfoMapper;

	@Override
	public NULL service(List<Userinfo> param, Map<String, Object> operat) throws ConsumerException {

		// 获取操作类型
		String optType = String.valueOf(operat.get(FieldNames.OPERATYPE));
		// log.info("UserService the operation is as follows:{}", optType);

		if (DbOperatTypeEnum.OPERAT_ADD.getValues().equals(optType)) {
			// param.stream().forEach(userinfo -> {
			// userinfoMapper.insert(userinfo);
			// });
			for (Userinfo userinfo : param) {
				userinfoMapper.insert(userinfo);
			}
		}

		if (DbOperatTypeEnum.OPERAT_UPDATE.getValues().equals(optType)) {
			// param.stream().forEach(userinfo -> {
			// userinfoMapper.updateByPrimaryKeySelective(userinfo);
			// });
			for (Userinfo userinfo : param) {
				userinfoMapper.updateByPrimaryKeySelective(userinfo);
			}
		}

		return null;
	}

}
