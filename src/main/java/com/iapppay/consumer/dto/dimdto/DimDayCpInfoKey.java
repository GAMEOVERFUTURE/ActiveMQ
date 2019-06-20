package com.iapppay.consumer.dto.dimdto;

/**
 * 
 * @className: DimDayCpInfoKey
 * @classDescription:DIM商户基本信息KEY
 * @author lishiqiang
 * @create_date: 2019年5月7日 上午9:40:13
 * @update_date:
 */
public class DimDayCpInfoKey {
    private Integer statdate;

    private Integer cpid;

    public Integer getStatdate() {
        return statdate;
    }

    public void setStatdate(Integer statdate) {
        this.statdate = statdate;
    }

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }
}