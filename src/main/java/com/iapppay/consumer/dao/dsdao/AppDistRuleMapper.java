package com.iapppay.consumer.dao.dsdao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dsdto.AppDistRule;
import com.iapppay.consumer.dto.dsdto.AppDistRuleKey;

/**
 * 
 * @className: AppDistRuleMapper
 * @classDescription:应用分润规则DAO
 * @author lishiqiang
 * @create_date: 2019年5月14日 下午5:17:53
 * @update_date:
 */
@Mapper
public interface AppDistRuleMapper {
    int deleteByPrimaryKey(AppDistRuleKey key);

    int insert(AppDistRule record);

    int insertSelective(AppDistRule record);

    AppDistRule selectByPrimaryKey(AppDistRuleKey key);

    int updateByPrimaryKeySelective(AppDistRule record);

    int updateByPrimaryKey(AppDistRule record);

	/**
	 * 批量插入规则
	 * 
	 * @param distRules
	 * @return
	 */
	int batchInsert(List<AppDistRule> distRules);

	/**
	 * 条件删除
	 * 
	 * @param params
	 * @return
	 */
	int deleteRulesByParams(Map<String, Object> params);
}