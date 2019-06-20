package com.iapppay.consumer.dto.dsdto;

/**
 * 
 * @className: AppDistRuleKey
 * @classDescription:应用分润规则对象key
 * @author lishiqiang
 * @create_date: 2019年5月14日 下午5:17:01
 * @update_date:
 */
public class AppDistRuleKey {
    private String appid;

    private Integer acid;

    private Integer cpid;

    private Integer platid;

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

    public Integer getPlatid() {
        return platid;
    }

    public void setPlatid(Integer platid) {
        this.platid = platid;
    }
}