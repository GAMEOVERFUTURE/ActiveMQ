package com.iapppay.consumer.dao.dsdao;

import org.apache.ibatis.annotations.Mapper;

import com.iapppay.consumer.dto.dsdto.DsWares;

/**
 * 
 * @className: DsWaresMapper
 * @classDescription:应用DAO
 * @author lishiqiang
 * @create_date: 2019年5月14日 下午5:08:26
 * @update_date:
 */
@Mapper
public interface DsWaresMapper {
    int deleteByPrimaryKey(String waresid);

    int insert(DsWares record);

    int insertSelective(DsWares record);

    DsWares selectByPrimaryKey(String waresid);

    int updateByPrimaryKeySelective(DsWares record);

    int updateByPrimaryKey(DsWares record);

	/**
	 * 查询是否已经存在
	 * 
	 * @param waresid
	 * @return
	 */
	int getExistDsWares(String waresid);
}