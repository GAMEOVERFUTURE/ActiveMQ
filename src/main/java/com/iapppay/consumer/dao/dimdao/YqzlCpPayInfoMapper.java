package com.iapppay.consumer.dao.dimdao;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dimdto.YqzlCpPayInfo;
import com.iapppay.consumer.dto.dimdto.YqzlCpPayInfoKey;

/**
 * 
 * @className: YqzlCpPayInfoMapperMapper
 * @classDescription:DIM中CP_BANK存储DAO
 * @author lishiqiang
 * @create_date: 2019年4月28日 下午2:07:15
 * @update_date:
 */
@Mapper
public interface YqzlCpPayInfoMapper {

    int deleteByPrimaryKey(YqzlCpPayInfoKey key);


    int insert(YqzlCpPayInfo record);


    int insertSelective(YqzlCpPayInfo record);


    YqzlCpPayInfo selectByPrimaryKey(YqzlCpPayInfoKey key);


    int updateByPrimaryKeySelective(YqzlCpPayInfo record);

    int updateByPrimaryKey(YqzlCpPayInfo record);
}