package com.iapppay.consumer.dao.dimdao;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dimdto.DimDayCpInfo;
import com.iapppay.consumer.dto.dimdto.DimDayCpInfoKey;

/**
 * 
 * @className: DimDayCpInfoMapper
 * @classDescription:商户基本信息DAO
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午9:41:23
 * @update_date:
 */
@Mapper
public interface DimDayCpInfoMapper {
    int deleteByPrimaryKey(DimDayCpInfoKey key);

    int insert(DimDayCpInfo record);

    int insertSelective(DimDayCpInfo record);

    DimDayCpInfo selectByPrimaryKey(DimDayCpInfoKey key);

    int updateByPrimaryKeySelective(DimDayCpInfo record);

    int updateByPrimaryKey(DimDayCpInfo record);
}