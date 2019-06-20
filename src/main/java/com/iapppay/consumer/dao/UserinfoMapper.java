package com.iapppay.consumer.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.iapppay.consumer.framework.entity.request.Userinfo;

@Mapper
public interface UserinfoMapper {
	int deleteByPrimaryKey(Integer userid);

	int insert(Userinfo record);

	int insertSelective(Userinfo record);

	Userinfo selectByPrimaryKey(Integer userid);

	int updateByPrimaryKeySelective(Userinfo record);

	int updateByPrimaryKey(Userinfo record);

	Userinfo selectByName(@Param("loginname") String logiNname);
}