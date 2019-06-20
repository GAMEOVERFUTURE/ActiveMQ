package com.iapppay.consumer.dao.dsdao;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dsdto.DsCpBase;

/**
 * 
 * @className: DsCpBaseMapper
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午3:00:30
 * @update_date:
 */
@Mapper
public interface DsCpBaseMapper {
    int deleteByPrimaryKey(Integer cpid);

    int insert(DsCpBase record);

    int insertSelective(DsCpBase record);

    DsCpBase selectByPrimaryKey(Integer cpid);

    int updateByPrimaryKeySelective(DsCpBase record);

    int updateByPrimaryKey(DsCpBase record);
}