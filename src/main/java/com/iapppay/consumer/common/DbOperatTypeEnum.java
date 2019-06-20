package com.iapppay.consumer.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @className: DbOperatTypeEnum
 * @classDescription:针对数据库操作的类型
 * @author lishiqiang
 * @create_date: 2019年4月25日 下午5:51:57
 * @update_date:
 */
public enum DbOperatTypeEnum {

	/**
	 * 新增
	 */
	OPERAT_ADD("add"),

	/**
	 * 修改
	 */
	OPERAT_UPDATE("update"),

	/**
	 * 迁移或转让
	 */
	OPERAT_TRANSFER("transfer"),

	/**
	 * 删除
	 */
	OPERAT_DELETE("delete"),

	/**
	 * 覆盖新增
	 */
	OPERAT_DELETE_ADD("delete-add"),

	/**
	 * 批量新增
	 */
	OPERAT_BATCH_ADD("batch-add"),

	/**
	 * 批量修改
	 */
	OPERAT_BATCH_UPDATE("batch-update"),

	/**
	 * 批量删除
	 */
	OPERAT_BATCH_DELETE("batch-delete"),

	/**
	 * 批量覆盖
	 */
	BATCH_DELETE_ADD("batch-delete-add");

	private String values;

	DbOperatTypeEnum(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}

	public static boolean checkType(String values) {
		for (DbOperatTypeEnum operatTypeEnum : DbOperatTypeEnum.values()) {
			if (StringUtils.equals(values, operatTypeEnum.getValues())) {
				return true;
			}
		}
		return false;
	}

}
