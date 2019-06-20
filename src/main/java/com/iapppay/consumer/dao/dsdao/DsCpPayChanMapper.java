package com.iapppay.consumer.dao.dsdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dsdto.DsCpPayChan;
import com.iapppay.consumer.dto.dsdto.DsCpPayChanKey;

/**
 * 
 * @className: DsCpPayChanMapper
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午3:01:46
 * @update_date:
 */
@Mapper
public interface DsCpPayChanMapper {

    int deleteByPrimaryKey(DsCpPayChanKey key);

    int insert(DsCpPayChan record);

    int insertSelective(DsCpPayChan record);

    DsCpPayChan selectByPrimaryKey(DsCpPayChanKey key);

    int updateByPrimaryKeySelective(DsCpPayChan record);

    int updateByPrimaryKey(DsCpPayChan record);

	/**
	 * 批量插入规则
	 * 
	 * @param ruleList
	 * @return
	 */
	int foreachInsert(List<DsCpPayChan> payChanList);

	/**
	 * 批量删除
	 * 
	 * @param ruleList
	 * @return
	 */
	int foreachDelete(List<DsCpPayChan> payChanList);
}