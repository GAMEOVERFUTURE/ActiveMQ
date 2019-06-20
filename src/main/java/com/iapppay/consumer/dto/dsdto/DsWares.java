package com.iapppay.consumer.dto.dsdto;

import java.util.Date;

/**
 * 
 * @className: DsWares
 * @classDescription:应用实体类
 * @author lishiqiang
 * @create_date: 2019年5月14日 下午5:05:02
 * @update_date:
 */
public class DsWares {

	private String waresid;

    private String waresname;

	private Integer cpid;

    private String cpname;

	private Integer apid;

    private Integer platid;

    private String apname;

    private String waresstatus;

    private Integer via;

    private String lable;

    private String weresdesc;

    private String thumb;

    private String servphone;

    private Integer grade;

    private Date createtime;

    private Date onlinetime;

    private Date offlinetime;

    private Date lastupdtime;

    private String appkey;

    private String appresppkey;

    private String apprespvkey;

    private String appmodkey;

    private Integer cacheflag;

    private Integer transsyncflag;

    private String transsyncaddr;

    private Integer syncrespflag;

    private Integer transsyncver;

    private Integer priceversion;

    private Integer ifunique;

    private Integer commnum;

    private String plattype;

    private String apptype;

    private String appchildtype;

    private Integer usefirstacid;

    private Integer usefirstacid2;

    private String devicetype;

    private Integer rsaversion;

    private String cppkey;

    private String cpvkey;

    private String platpkey;

    private String platvkey;

    private Integer groupid;

    private String appchinaappid;

    private String appchinaappkey;

    private String appchinapackage;

    private Integer cusgroupid;

    public String getWaresid() {
        return waresid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.waresid
     *
     * @param waresid the value for ds_wares.waresid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setWaresid(String waresid) {
        this.waresid = waresid == null ? null : waresid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.waresname
     *
     * @return the value of ds_wares.waresname
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getWaresname() {
        return waresname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.waresname
     *
     * @param waresname the value for ds_wares.waresname
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setWaresname(String waresname) {
        this.waresname = waresname == null ? null : waresname.trim();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.cpname
     *
     * @return the value of ds_wares.cpname
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getCpname() {
        return cpname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.cpname
     *
     * @param cpname the value for ds_wares.cpname
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setCpname(String cpname) {
        this.cpname = cpname == null ? null : cpname.trim();
    }


	public Integer getCpid() {
		return cpid;
	}

	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	public Integer getApid() {
		return apid;
	}

	public void setApid(Integer apid) {
		this.apid = apid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value
	 * of the database column ds_wares.platid
	 *
	 * @return the value of ds_wares.platid
	 *
	 * @mbg.generated Tue May 14 17:04:39 CST 2019
	 */
    public Integer getPlatid() {
        return platid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.platid
     *
     * @param platid the value for ds_wares.platid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setPlatid(Integer platid) {
        this.platid = platid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.apname
     *
     * @return the value of ds_wares.apname
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getApname() {
        return apname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.apname
     *
     * @param apname the value for ds_wares.apname
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setApname(String apname) {
        this.apname = apname == null ? null : apname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.waresstatus
     *
     * @return the value of ds_wares.waresstatus
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getWaresstatus() {
        return waresstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.waresstatus
     *
     * @param waresstatus the value for ds_wares.waresstatus
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setWaresstatus(String waresstatus) {
        this.waresstatus = waresstatus == null ? null : waresstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.via
     *
     * @return the value of ds_wares.via
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getVia() {
        return via;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.via
     *
     * @param via the value for ds_wares.via
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setVia(Integer via) {
        this.via = via;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.lable
     *
     * @return the value of ds_wares.lable
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getLable() {
        return lable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.lable
     *
     * @param lable the value for ds_wares.lable
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.weresdesc
     *
     * @return the value of ds_wares.weresdesc
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getWeresdesc() {
        return weresdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.weresdesc
     *
     * @param weresdesc the value for ds_wares.weresdesc
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setWeresdesc(String weresdesc) {
        this.weresdesc = weresdesc == null ? null : weresdesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.thumb
     *
     * @return the value of ds_wares.thumb
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.thumb
     *
     * @param thumb the value for ds_wares.thumb
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.servphone
     *
     * @return the value of ds_wares.servphone
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getServphone() {
        return servphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.servphone
     *
     * @param servphone the value for ds_wares.servphone
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setServphone(String servphone) {
        this.servphone = servphone == null ? null : servphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.grade
     *
     * @return the value of ds_wares.grade
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.grade
     *
     * @param grade the value for ds_wares.grade
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.createtime
     *
     * @return the value of ds_wares.createtime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.createtime
     *
     * @param createtime the value for ds_wares.createtime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.onlinetime
     *
     * @return the value of ds_wares.onlinetime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Date getOnlinetime() {
        return onlinetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.onlinetime
     *
     * @param onlinetime the value for ds_wares.onlinetime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setOnlinetime(Date onlinetime) {
        this.onlinetime = onlinetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.offlinetime
     *
     * @return the value of ds_wares.offlinetime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Date getOfflinetime() {
        return offlinetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.offlinetime
     *
     * @param offlinetime the value for ds_wares.offlinetime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setOfflinetime(Date offlinetime) {
        this.offlinetime = offlinetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.lastupdtime
     *
     * @return the value of ds_wares.lastupdtime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Date getLastupdtime() {
        return lastupdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.lastupdtime
     *
     * @param lastupdtime the value for ds_wares.lastupdtime
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setLastupdtime(Date lastupdtime) {
        this.lastupdtime = lastupdtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.appkey
     *
     * @return the value of ds_wares.appkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getAppkey() {
        return appkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.appkey
     *
     * @param appkey the value for ds_wares.appkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setAppkey(String appkey) {
        this.appkey = appkey == null ? null : appkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.appresppkey
     *
     * @return the value of ds_wares.appresppkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getAppresppkey() {
        return appresppkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.appresppkey
     *
     * @param appresppkey the value for ds_wares.appresppkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setAppresppkey(String appresppkey) {
        this.appresppkey = appresppkey == null ? null : appresppkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.apprespvkey
     *
     * @return the value of ds_wares.apprespvkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getApprespvkey() {
        return apprespvkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.apprespvkey
     *
     * @param apprespvkey the value for ds_wares.apprespvkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setApprespvkey(String apprespvkey) {
        this.apprespvkey = apprespvkey == null ? null : apprespvkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.appmodkey
     *
     * @return the value of ds_wares.appmodkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getAppmodkey() {
        return appmodkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.appmodkey
     *
     * @param appmodkey the value for ds_wares.appmodkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setAppmodkey(String appmodkey) {
        this.appmodkey = appmodkey == null ? null : appmodkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.cacheflag
     *
     * @return the value of ds_wares.cacheflag
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getCacheflag() {
        return cacheflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.cacheflag
     *
     * @param cacheflag the value for ds_wares.cacheflag
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setCacheflag(Integer cacheflag) {
        this.cacheflag = cacheflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.transsyncflag
     *
     * @return the value of ds_wares.transsyncflag
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getTranssyncflag() {
        return transsyncflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.transsyncflag
     *
     * @param transsyncflag the value for ds_wares.transsyncflag
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setTranssyncflag(Integer transsyncflag) {
        this.transsyncflag = transsyncflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.transsyncaddr
     *
     * @return the value of ds_wares.transsyncaddr
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getTranssyncaddr() {
        return transsyncaddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.transsyncaddr
     *
     * @param transsyncaddr the value for ds_wares.transsyncaddr
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setTranssyncaddr(String transsyncaddr) {
        this.transsyncaddr = transsyncaddr == null ? null : transsyncaddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.syncrespflag
     *
     * @return the value of ds_wares.syncrespflag
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getSyncrespflag() {
        return syncrespflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.syncrespflag
     *
     * @param syncrespflag the value for ds_wares.syncrespflag
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setSyncrespflag(Integer syncrespflag) {
        this.syncrespflag = syncrespflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.transsyncver
     *
     * @return the value of ds_wares.transsyncver
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getTranssyncver() {
        return transsyncver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.transsyncver
     *
     * @param transsyncver the value for ds_wares.transsyncver
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setTranssyncver(Integer transsyncver) {
        this.transsyncver = transsyncver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.priceversion
     *
     * @return the value of ds_wares.priceversion
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getPriceversion() {
        return priceversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.priceversion
     *
     * @param priceversion the value for ds_wares.priceversion
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setPriceversion(Integer priceversion) {
        this.priceversion = priceversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.ifunique
     *
     * @return the value of ds_wares.ifunique
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getIfunique() {
        return ifunique;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.ifunique
     *
     * @param ifunique the value for ds_wares.ifunique
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setIfunique(Integer ifunique) {
        this.ifunique = ifunique;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.commnum
     *
     * @return the value of ds_wares.commnum
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getCommnum() {
        return commnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.commnum
     *
     * @param commnum the value for ds_wares.commnum
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setCommnum(Integer commnum) {
        this.commnum = commnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.plattype
     *
     * @return the value of ds_wares.plattype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getPlattype() {
        return plattype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.plattype
     *
     * @param plattype the value for ds_wares.plattype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setPlattype(String plattype) {
        this.plattype = plattype == null ? null : plattype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.apptype
     *
     * @return the value of ds_wares.apptype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getApptype() {
        return apptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.apptype
     *
     * @param apptype the value for ds_wares.apptype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setApptype(String apptype) {
        this.apptype = apptype == null ? null : apptype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.appchildtype
     *
     * @return the value of ds_wares.appchildtype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getAppchildtype() {
        return appchildtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.appchildtype
     *
     * @param appchildtype the value for ds_wares.appchildtype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setAppchildtype(String appchildtype) {
        this.appchildtype = appchildtype == null ? null : appchildtype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.usefirstacid
     *
     * @return the value of ds_wares.usefirstacid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getUsefirstacid() {
        return usefirstacid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.usefirstacid
     *
     * @param usefirstacid the value for ds_wares.usefirstacid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setUsefirstacid(Integer usefirstacid) {
        this.usefirstacid = usefirstacid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.usefirstacid2
     *
     * @return the value of ds_wares.usefirstacid2
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getUsefirstacid2() {
        return usefirstacid2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.usefirstacid2
     *
     * @param usefirstacid2 the value for ds_wares.usefirstacid2
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setUsefirstacid2(Integer usefirstacid2) {
        this.usefirstacid2 = usefirstacid2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.devicetype
     *
     * @return the value of ds_wares.devicetype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getDevicetype() {
        return devicetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.devicetype
     *
     * @param devicetype the value for ds_wares.devicetype
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype == null ? null : devicetype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.rsaversion
     *
     * @return the value of ds_wares.rsaversion
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getRsaversion() {
        return rsaversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.rsaversion
     *
     * @param rsaversion the value for ds_wares.rsaversion
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setRsaversion(Integer rsaversion) {
        this.rsaversion = rsaversion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.cppkey
     *
     * @return the value of ds_wares.cppkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getCppkey() {
        return cppkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.cppkey
     *
     * @param cppkey the value for ds_wares.cppkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setCppkey(String cppkey) {
        this.cppkey = cppkey == null ? null : cppkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.cpvkey
     *
     * @return the value of ds_wares.cpvkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getCpvkey() {
        return cpvkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.cpvkey
     *
     * @param cpvkey the value for ds_wares.cpvkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setCpvkey(String cpvkey) {
        this.cpvkey = cpvkey == null ? null : cpvkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.platpkey
     *
     * @return the value of ds_wares.platpkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getPlatpkey() {
        return platpkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.platpkey
     *
     * @param platpkey the value for ds_wares.platpkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setPlatpkey(String platpkey) {
        this.platpkey = platpkey == null ? null : platpkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.platvkey
     *
     * @return the value of ds_wares.platvkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getPlatvkey() {
        return platvkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.platvkey
     *
     * @param platvkey the value for ds_wares.platvkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setPlatvkey(String platvkey) {
        this.platvkey = platvkey == null ? null : platvkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.groupid
     *
     * @return the value of ds_wares.groupid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.groupid
     *
     * @param groupid the value for ds_wares.groupid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.appchinaappid
     *
     * @return the value of ds_wares.appchinaappid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getAppchinaappid() {
        return appchinaappid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.appchinaappid
     *
     * @param appchinaappid the value for ds_wares.appchinaappid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setAppchinaappid(String appchinaappid) {
        this.appchinaappid = appchinaappid == null ? null : appchinaappid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.appchinaappkey
     *
     * @return the value of ds_wares.appchinaappkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getAppchinaappkey() {
        return appchinaappkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.appchinaappkey
     *
     * @param appchinaappkey the value for ds_wares.appchinaappkey
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setAppchinaappkey(String appchinaappkey) {
        this.appchinaappkey = appchinaappkey == null ? null : appchinaappkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.appchinapackage
     *
     * @return the value of ds_wares.appchinapackage
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public String getAppchinapackage() {
        return appchinapackage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.appchinapackage
     *
     * @param appchinapackage the value for ds_wares.appchinapackage
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setAppchinapackage(String appchinapackage) {
        this.appchinapackage = appchinapackage == null ? null : appchinapackage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ds_wares.cusgroupid
     *
     * @return the value of ds_wares.cusgroupid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public Integer getCusgroupid() {
        return cusgroupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ds_wares.cusgroupid
     *
     * @param cusgroupid the value for ds_wares.cusgroupid
     *
     * @mbg.generated Tue May 14 17:04:39 CST 2019
     */
    public void setCusgroupid(Integer cusgroupid) {
        this.cusgroupid = cusgroupid;
    }
}