package com.iapppay.consumer.dao.dsdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dsdto.DsCpAccoRules;

/**
 * 
 * @className: DsCpAccoRulesMapper
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午2:59:58
 * @update_date:
 */
@Mapper
public interface DsCpAccoRulesMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(DsCpAccoRules record);

    int insertSelective(DsCpAccoRules record);

    DsCpAccoRules selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DsCpAccoRules record);

    int updateByPrimaryKey(DsCpAccoRules record);

	/**
	 * 批量插入规则
	 * 
	 * @param ruleList
	 * @return
	 */
	int foreachInsert(List<DsCpAccoRules> ruleList);

	/**
	 * 批量删除
	 * 
	 * @param ruleList
	 * @return
	 */
	int foreachDelete(List<DsCpAccoRules> ruleList);
}