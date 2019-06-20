package com.iapppay.consumer.framework.entity.request;

import com.iapppay.consumer.framework.entity.MessageCheck;
import com.iapppay.consumer.framework.entity.OptionalEnum;

/**
 * 
 * @className: BankInfo
 * @classDescription:银行信息
 * @author lishiqiang
 * @create_date: 2019年4月26日 下午2:32:13
 * @update_date:
 */
public class BankInfo {

	/**
	 * 主键ID
	 */
	@MessageCheck(con = OptionalEnum.M, regular = "^[0-9]*$")
	public Integer cpid;

	/**
	 * 银行名称
	 */
	@MessageCheck(con = OptionalEnum.O, regular = "^.{1,128}$")
	public String bankname;

	/**
	 * 商户名称
	 */
	@MessageCheck(con = OptionalEnum.O, regular = "^.{1,128}$")
	public String accountname;

	/**
	 * 商户ID
	 */
	@MessageCheck(con = OptionalEnum.O, regular = "^.{1,128}$")
	public String accountid;

	public Integer getCpid() {
		return cpid;
	}

	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
}
