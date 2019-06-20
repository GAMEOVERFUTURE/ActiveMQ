package com.iapppay.consumer.dao.dimdao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dimdto.DimAppDistRules;

/**
 * 
 * @className: AppShareProfitRulesMapper
 * @classDescription:应用分润规则记录DAO
 * @author lishiqiang
 * @create_date: 2019年5月15日 上午11:28:28
 * @update_date:
 */
@Mapper
public interface DimAppDistRulesMapper {

    int deleteByPrimaryKey(Integer ruleid);

    int insert(DimAppDistRules record);

    int insertSelective(DimAppDistRules record);

    DimAppDistRules selectByPrimaryKey(Integer ruleid);

    int updateByPrimaryKeySelective(DimAppDistRules record);

    int updateByPrimaryKey(DimAppDistRules record);

	/**
	 * 修改状态
	 * 
	 * @param params
	 * @return
	 */
	int updateShateProfitStatus(Map<String, Object> params);

	/**
	 * 批量插入规则
	 * 
	 * @param distRules
	 * @return
	 */
	int batchInsert(List<DimAppDistRules> profitlist);
}