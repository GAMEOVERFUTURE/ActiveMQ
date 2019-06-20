package com.iapppay.consumer.framework.entity.request;

import java.util.Date;

import com.iapppay.consumer.framework.entity.MessageCheck;
import com.iapppay.consumer.framework.entity.OptionalEnum;

/**
 * 
 * @className: DsCpBase
 * @classDescription:商户基本信息
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午2:51:02
 * @update_date:
 */
public class CpBaseInfo {

	@MessageCheck(con = OptionalEnum.M, regular = "^[0-9]*$")
	public Integer cpid;

	@MessageCheck(con = OptionalEnum.M, regular = "^\\d{1}$")
	public Integer cptype;

	@MessageCheck(con = OptionalEnum.M, regular = "^\\d{1}$")
	public Integer cplevel;

	@MessageCheck(regular = "^[a-zA-Z0-9]{2}$")
	public String cpstatus;

	@MessageCheck(regular = "^.{1,64}$")
	public String cpname;

	public Date regtime;

	@MessageCheck(con = OptionalEnum.M, regular = "^\\d{1}$")
	public Integer systemid;

	@MessageCheck(regular = "^.{1,64}$")
	public String excpid;

	public Integer iftest;

	public Integer cpunit;

	public String industrytype;

	@MessageCheck(regular = "^[a-zA-Z0-9]{20}$")
	public String recstat;

	public Integer platid;

	public Integer parentcpid;

	public Integer bussinesstype;

	public String balancecall;

	@MessageCheck(regular = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
	public String bindemail;

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getCptype() {
        return cptype;
    }


    public void setCptype(Integer cptype) {
        this.cptype = cptype;
    }


    public Integer getCplevel() {
        return cplevel;
    }


    public void setCplevel(Integer cplevel) {
        this.cplevel = cplevel;
    }


    public String getCpstatus() {
        return cpstatus;
    }


    public void setCpstatus(String cpstatus) {
        this.cpstatus = cpstatus == null ? null : cpstatus.trim();
    }


    public String getCpname() {
        return cpname;
    }


    public void setCpname(String cpname) {
        this.cpname = cpname == null ? null : cpname.trim();
    }


    public Date getRegtime() {
        return regtime;
    }


    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }


    public Integer getSystemid() {
        return systemid;
    }


    public void setSystemid(Integer systemid) {
        this.systemid = systemid;
    }

    public String getExcpid() {
        return excpid;
    }


    public void setExcpid(String excpid) {
        this.excpid = excpid == null ? null : excpid.trim();
    }


    public Integer getIftest() {
        return iftest;
    }


    public void setIftest(Integer iftest) {
        this.iftest = iftest;
    }


    public Integer getCpunit() {
        return cpunit;
    }


    public void setCpunit(Integer cpunit) {
        this.cpunit = cpunit;
    }

	public String getIndustrytype() {
		return industrytype;
	}

	public void setIndustrytype(String industrytype) {
		this.industrytype = industrytype;
	}

	public String getRecstat() {
        return recstat;
    }


    public void setRecstat(String recstat) {
        this.recstat = recstat == null ? null : recstat.trim();
    }


    public Integer getPlatid() {
        return platid;
    }

    public void setPlatid(Integer platid) {
        this.platid = platid;
    }

    public Integer getParentcpid() {
        return parentcpid;
    }


    public void setParentcpid(Integer parentcpid) {
        this.parentcpid = parentcpid;
    }


    public Integer getBussinesstype() {
        return bussinesstype;
    }


    public void setBussinesstype(Integer bussinesstype) {
        this.bussinesstype = bussinesstype;
    }

    public String getBalancecall() {
        return balancecall;
    }


    public void setBalancecall(String balancecall) {
        this.balancecall = balancecall == null ? null : balancecall.trim();
    }


    public String getBindemail() {
        return bindemail;
    }


    public void setBindemail(String bindemail) {
        this.bindemail = bindemail == null ? null : bindemail.trim();
    }
}