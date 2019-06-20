package com.iapppay.consumer.dto.dsdto;

import java.util.Date;

/**
 * 
 * @className: AppDistRule
 * @classDescription:应用分润规则对象
 * @author lishiqiang
 * @create_date: 2019年5月14日 下午5:16:18
 * @update_date:
 */
public class AppDistRule extends AppDistRuleKey {
    private Double distrate;

    private Date createtime;

    public Double getDistrate() {
        return distrate;
    }

    public void setDistrate(Double distrate) {
        this.distrate = distrate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}