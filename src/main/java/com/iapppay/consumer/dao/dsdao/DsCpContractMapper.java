package com.iapppay.consumer.dao.dsdao;

import com.iapppay.consumer.dto.dsdto.DsCpContract;

/**
 * 
 * @className: DsCpContractMapper
 * @classDescription:
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午3:01:00
 * @update_date:
 */
public interface DsCpContractMapper {
    int deleteByPrimaryKey(Integer cpid);

    int insert(DsCpContract record);

    int insertSelective(DsCpContract record);

    DsCpContract selectByPrimaryKey(Integer cpid);

    int updateByPrimaryKeySelective(DsCpContract record);

    int updateByPrimaryKey(DsCpContract record);
}