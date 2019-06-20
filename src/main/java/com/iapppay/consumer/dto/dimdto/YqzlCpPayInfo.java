package com.iapppay.consumer.dto.dimdto;

import java.util.Date;

/**
 * 
 * @className: YqzlCpPayInfo
 * @classDescription:DIM数据层CP_BANK对象
 * @author lishiqiang
 * @create_date: 2019年4月28日 下午2:11:42
 * @update_date:
 */
public class YqzlCpPayInfo extends YqzlCpPayInfoKey {

	/**
	 * 收款方账户
	 */
	private String rcvaccount;

	/**
	 * 收款方账户名称
	 */
	private String rcvaccountname;

	/**
	 * 收款方开户银行
	 */
	private String rcvopenbank;

	/**
	 * 银行标识
	 */
	private String bankflag;

	/**
	 * 地区标识
	 */
	private String areaflag;

	/**
	 * 最后更新操作人
	 */
	private Integer updateby;

	/**
	 * 最后更新时间
	 */
	private Date lastupdatetime;

	public String getRcvaccount() {
		return rcvaccount;
	}

	public void setRcvaccount(String rcvaccount) {
		this.rcvaccount = rcvaccount == null ? null : rcvaccount.trim();
	}

	public String getRcvaccountname() {
		return rcvaccountname;
	}

	public void setRcvaccountname(String rcvaccountname) {
		this.rcvaccountname = rcvaccountname == null ? null : rcvaccountname.trim();
	}

	public String getRcvopenbank() {
		return rcvopenbank;
	}

	public void setRcvopenbank(String rcvopenbank) {
		this.rcvopenbank = rcvopenbank == null ? null : rcvopenbank.trim();
	}

	public String getBankflag() {
		return bankflag;
	}

	public void setBankflag(String bankflag) {
		this.bankflag = bankflag;
	}

	public String getAreaflag() {
		return areaflag;
	}

	public void setAreaflag(String areaflag) {
		this.areaflag = areaflag;
	}

	public Integer getUpdateby() {
		return updateby;
	}

	public void setUpdateby(Integer updateby) {
		this.updateby = updateby;
	}

	public Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}


}