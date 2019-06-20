package com.iapppay.consumer.dto.dsdto;

/**
 * 
 * @className: DsCpBank
 * @classDescription:DS数据层CP_BANK对象
 * @author lishiqiang
 * @create_date: 2019年4月28日 下午2:26:54
 * @update_date:
 */
public class DsCpBank {

	/**
	 * 商户ID
	 */
	private Integer cpid;

	/**
	 * 银行名称
	 */
    private String bankname;

    /**
	 * 收款人账号名称
	 */
    private String accountname;

    /**
	 * 收款人账号ID
	 */
    private String accountid;

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
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid == null ? null : accountid.trim();
    }
}