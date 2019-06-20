package com.iapppay.consumer.dto.dsdto;

/**
 * 
 * @className: DsCpPayChanKey
 * @classDescription:商户支付通道信息KEY
 * @author lishiqiang
 * @create_date: 2019年5月6日 下午2:56:30
 * @update_date:
 */
public class DsCpPayChanKey {
    private Integer cpid;

    private Integer platchanno;

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public Integer getPlatchanno() {
        return platchanno;
    }

    public void setPlatchanno(Integer platchanno) {
        this.platchanno = platchanno;
    }
}