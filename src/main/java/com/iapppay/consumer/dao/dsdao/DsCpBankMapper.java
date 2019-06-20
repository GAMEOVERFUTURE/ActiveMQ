package com.iapppay.consumer.dao.dsdao;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dsdto.DsCpBank;

/**
 * 
 * @className: DsCpBankMapperMapper
 * @classDescription:DS数据CP_BANK存储DAO
 * @author lishiqiang
 * @create_date: 2019年4月28日 下午2:08:06
 * @update_date:
 */
@Mapper
public interface DsCpBankMapper {

    int deleteByPrimaryKey(Integer cpid);

    int insert(DsCpBank record);

    int insertSelective(DsCpBank record);

    DsCpBank selectByPrimaryKey(Integer cpid);

    int updateByPrimaryKeySelective(DsCpBank record);

    int updateByPrimaryKey(DsCpBank record);
}