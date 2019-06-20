package com.iapppay.consumer.framework.entity.request;

import java.math.BigDecimal;

import com.iapppay.consumer.framework.entity.MessageCheck;
import com.iapppay.consumer.framework.entity.OptionalEnum;

/**
 * 
 * @className: DsCpAccoRules
 * @classDescription:爱贝服务费计费规则
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午2:29:15
 * @update_date:
 */
public class CpAccoRulesInfo extends RequestBody {

	/**
	 * 主键ID
	 */
	@MessageCheck(con = OptionalEnum.M)
	public Integer id;

	/**
	 * 商户编号
	 */
	public Integer cpid;

	/**
	 * 起始值
	 */
	public BigDecimal startval;

	/**
	 * 结束值
	 */
	public BigDecimal endval;

	/**
	 * 爱贝费率
	 */
	public Double cprate;

	/**
	 * 最小费率
	 */
	public Double minfee;

	/**
	 * 最大费率
	 */
	public Double maxfee;

	/**
	 * 备注
	 */
	public String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public BigDecimal getStartval() {
        return startval;
    }

    public void setStartval(BigDecimal startval) {
        this.startval = startval;
    }

    public BigDecimal getEndval() {
        return endval;
    }

    public void setEndval(BigDecimal endval) {
        this.endval = endval;
    }

    public Double getCprate() {
        return cprate;
    }

    public void setCprate(Double cprate) {
        this.cprate = cprate;
    }

    public Double getMinfee() {
        return minfee;
    }

    public void setMinfee(Double minfee) {
        this.minfee = minfee;
    }

    public Double getMaxfee() {
        return maxfee;
    }

    public void setMaxfee(Double maxfee) {
        this.maxfee = maxfee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}