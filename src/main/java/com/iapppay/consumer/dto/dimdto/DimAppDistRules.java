package com.iapppay.consumer.dto.dimdto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @className: AppShareProfitRules
 * @classDescription:应用分润规则记录对象
 * @author lishiqiang
 * @create_date: 2019年5月15日 上午11:24:22
 * @update_date:
 */
public class DimAppDistRules {

    private Integer ruleid;

    private String appid;

    private Integer acid;

    private Integer cpid;

	private BigDecimal distrate;

    private String status;

    private Date createtime;

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

	public BigDecimal getDistrate() {
		return distrate;
	}

	public void setDistrate(BigDecimal distrate) {
		this.distrate = distrate;
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}