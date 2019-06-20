package com.iapppay.consumer.dao.dimdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dimdto.DimPaychanRef;

/**
 * 
 * @className: DimPaychanRefMapper
 * @classDescription:产品大类Dao
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午11:26:57
 * @update_date:
 */
@Mapper
public interface DimPaychanRefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DimPaychanRef record);

    int insertSelective(DimPaychanRef record);

    DimPaychanRef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DimPaychanRef record);

    int updateByPrimaryKey(DimPaychanRef record);

	/**
	 * 获取所有配置信息
	 * @return
	 */
	List<DimPaychanRef> findAllDimPayChanRef();
}