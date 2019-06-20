package com.iapppay.consumer.framework.entity.request;

import java.util.Date;

/**
 * 
 * @className: DsCpContract
 * @classDescription:回滚合同信息表
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午2:54:02
 * @update_date:
 */
public class CpContractInfo extends RequestBody {

	public Integer cpid;

	public String contbegtime;

	public String contendtime;

	public String isautorene;

	public String departid;

	public String workerid;

	public String servtype;

	public String balacyctype;

	public Date balacyctypetime;

	public Integer balacyctypevalue;

	public Date balacyctyptime;

	public Integer balacyctypvalue;

	public Double lowpaymoney;

	public String feecontr;

	public String freebegtime;

	public String freeendtime;

	public Date recdate;

	public Date upddate;

	public Double montranflow;

	public Integer transfercpid;

	public String transfercpname;

	public String transfertime;

	public String transfernote;

	public Integer istransfer;

	public String ratetemplate;

	public Integer iselecontract;

	public String effectivetime;

	public String formaltime;

	public Integer contraaudistatus;

	public Integer contratype;

	public String cpmode;

	public String agentcompanycode;

	public Integer refundrule;

	public Integer auditeffect;

	public Integer getCpid() {
		return cpid;
	}

	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	public String getContbegtime() {
		return contbegtime;
	}

	public void setContbegtime(String contbegtime) {
		this.contbegtime = contbegtime;
	}

	public String getContendtime() {
		return contendtime;
	}

	public void setContendtime(String contendtime) {
		this.contendtime = contendtime;
	}

	public String getIsautorene() {
		return isautorene;
	}

	public void setIsautorene(String isautorene) {
		this.isautorene = isautorene;
	}

	public String getDepartid() {
		return departid;
	}

	public void setDepartid(String departid) {
		this.departid = departid;
	}

	public String getWorkerid() {
		return workerid;
	}

	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}

	public String getServtype() {
		return servtype;
	}

	public void setServtype(String servtype) {
		this.servtype = servtype;
	}

	public String getBalacyctype() {
		return balacyctype;
	}

	public void setBalacyctype(String balacyctype) {
		this.balacyctype = balacyctype;
	}


	public Double getLowpaymoney() {
		return lowpaymoney;
	}

	public void setLowpaymoney(Double lowpaymoney) {
		this.lowpaymoney = lowpaymoney;
	}

	public String getFeecontr() {
		return feecontr;
	}

	public void setFeecontr(String feecontr) {
		this.feecontr = feecontr;
	}

	public String getFreebegtime() {
		return freebegtime;
	}

	public void setFreebegtime(String freebegtime) {
		this.freebegtime = freebegtime;
	}

	public String getFreeendtime() {
		return freeendtime;
	}

	public void setFreeendtime(String freeendtime) {
		this.freeendtime = freeendtime;
	}

	public Date getRecdate() {
		return recdate;
	}

	public void setRecdate(Date recdate) {
		this.recdate = recdate;
	}

	public Date getUpddate() {
		return upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public Double getMontranflow() {
		return montranflow;
	}

	public void setMontranflow(Double montranflow) {
		this.montranflow = montranflow;
	}

	public Integer getTransfercpid() {
		return transfercpid;
	}

	public void setTransfercpid(Integer transfercpid) {
		this.transfercpid = transfercpid;
	}

	public String getTransfercpname() {
		return transfercpname;
	}

	public void setTransfercpname(String transfercpname) {
		this.transfercpname = transfercpname;
	}

	public String getTransfertime() {
		return transfertime;
	}

	public void setTransfertime(String transfertime) {
		this.transfertime = transfertime;
	}

	public String getTransfernote() {
		return transfernote;
	}

	public void setTransfernote(String transfernote) {
		this.transfernote = transfernote;
	}

	public Integer getIstransfer() {
		return istransfer;
	}

	public void setIstransfer(Integer istransfer) {
		this.istransfer = istransfer;
	}

	public String getRatetemplate() {
		return ratetemplate;
	}

	public void setRatetemplate(String ratetemplate) {
		this.ratetemplate = ratetemplate;
	}

	public Integer getIselecontract() {
		return iselecontract;
	}

	public void setIselecontract(Integer iselecontract) {
		this.iselecontract = iselecontract;
	}

	public String getEffectivetime() {
		return effectivetime;
	}

	public void setEffectivetime(String effectivetime) {
		this.effectivetime = effectivetime;
	}

	public String getFormaltime() {
		return formaltime;
	}

	public void setFormaltime(String formaltime) {
		this.formaltime = formaltime;
	}

	public Integer getContraaudistatus() {
		return contraaudistatus;
	}

	public void setContraaudistatus(Integer contraaudistatus) {
		this.contraaudistatus = contraaudistatus;
	}

	public Integer getContratype() {
		return contratype;
	}

	public void setContratype(Integer contratype) {
		this.contratype = contratype;
	}

	public String getCpmode() {
		return cpmode;
	}

	public void setCpmode(String cpmode) {
		this.cpmode = cpmode;
	}

	public Date getBalacyctypetime() {
		return balacyctypetime;
	}

	public void setBalacyctypetime(Date balacyctypetime) {
		this.balacyctypetime = balacyctypetime;
	}

	public Integer getBalacyctypevalue() {
		return balacyctypevalue;
	}

	public void setBalacyctypevalue(Integer balacyctypevalue) {
		this.balacyctypevalue = balacyctypevalue;
	}

	public Date getBalacyctyptime() {
		return balacyctyptime;
	}

	public void setBalacyctyptime(Date balacyctyptime) {
		this.balacyctyptime = balacyctyptime;
	}

	public Integer getBalacyctypvalue() {
		return balacyctypvalue;
	}

	public void setBalacyctypvalue(Integer balacyctypvalue) {
		this.balacyctypvalue = balacyctypvalue;
	}

	public String getAgentcompanycode() {
		return agentcompanycode;
	}

	public void setAgentcompanycode(String agentcompanycode) {
		this.agentcompanycode = agentcompanycode;
	}

	public Integer getRefundrule() {
		return refundrule;
	}

	public void setRefundrule(Integer refundrule) {
		this.refundrule = refundrule;
	}

	public Integer getAuditeffect() {
		return auditeffect;
	}

	public void setAuditeffect(Integer auditeffect) {
		this.auditeffect = auditeffect;
	}


}