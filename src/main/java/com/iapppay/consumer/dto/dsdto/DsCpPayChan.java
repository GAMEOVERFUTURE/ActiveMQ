package com.iapppay.consumer.dto.dsdto;

/**
 * 
 * @className: DsCpPayChan
 * @classDescription:商户支付通道信息
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午2:56:48
 * @update_date:
 */
public class DsCpPayChan extends DsCpPayChanKey {
	/**
	 * 爱贝手续费率
	 */
    private Double chanrate;

	/**
	 * 通道结算周期，10：月 11：周 12：N+1 13:N+2 14:N+3 ......
	 */
    private String balacyc;

	/**
	 * 通道最低手续费
	 */
    private Double minfee;

	/**
	 * 备注
	 */
    private String remark;

	/**
	 * 是否开通
	 */
    private String isenable;

	/**
	 * 支付大类编号
	 */
    private Integer paytype;

    public Double getChanrate() {
        return chanrate;
    }

    public void setChanrate(Double chanrate) {
        this.chanrate = chanrate;
    }

    public String getBalacyc() {
        return balacyc;
    }

    public void setBalacyc(String balacyc) {
        this.balacyc = balacyc == null ? null : balacyc.trim();
    }

    public Double getMinfee() {
        return minfee;
    }

    public void setMinfee(Double minfee) {
        this.minfee = minfee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getIsenable() {
        return isenable;
    }

    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    public Integer getPaytype() {
        return paytype;
    }
    public void setPaytype(Integer paytype) {
        this.paytype = paytype;
    }
}