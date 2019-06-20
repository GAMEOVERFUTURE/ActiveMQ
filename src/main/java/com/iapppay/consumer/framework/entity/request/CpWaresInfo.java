package com.iapppay.consumer.framework.entity.request;

import java.util.Date;
import java.util.List;

import com.iapppay.consumer.framework.entity.MessageCheck;
import com.iapppay.consumer.framework.entity.OptionalEnum;

/**
 * 
 * @className: CpWaresInfo
 * @classDescription:应用迁移转账新增请求对象
 * @author lishiqiang
 * @create_date: 2019年5月14日 下午5:19:57
 * @update_date:
 */
public class CpWaresInfo {

	@MessageCheck(con = OptionalEnum.M, regular = "^.{1,20}$")
	public String waresid;

	@MessageCheck(con = OptionalEnum.M, regular = "^.{1,64}$")
	public String waresname;

	@MessageCheck(con = OptionalEnum.M, regular = "^[0-9]*$")
	public Integer cpid;

	@MessageCheck(regular = "^.{1,64}$")
	public String cpname;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer apid;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer platid;

	@MessageCheck(regular = "^.{1,64}$")
	public String apname;

	@MessageCheck(con = OptionalEnum.M, content = { "A", "B", "C", "P", "T" })
	public String waresstatus;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer via;

	@MessageCheck(regular = "^.{1,100}$")
	public String lable;

	@MessageCheck(regular = "^.{1,1000}$")
	public String weresdesc;

	@MessageCheck(regular = "^.{1,1024}$")
	public String thumb;

	@MessageCheck(regular = "^.{1,30}$")
	public String servphone;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer grade;

	public Date createtime;

	public Date onlinetime;

	public Date offlinetime;

	public Date lastupdtime;

	@MessageCheck(regular = "^.{1,64}$")
	public String appkey;

	@MessageCheck(regular = "^.{1,64}$")
	public String appresppkey;

	@MessageCheck(regular = "^.{1,64}$")
	public String apprespvkey;

	@MessageCheck(regular = "^.{1,64}$")
	public String appmodkey;

	@MessageCheck(con = OptionalEnum.M, regular = "^\\d{1}$")
	public Integer cacheflag;

	@MessageCheck(regular = "^\\d{1}$")
	public Integer transsyncflag;

	@MessageCheck(regular = "^.{1,256}$")
	public String transsyncaddr;

	@MessageCheck(regular = "^\\d{1}$")
	public Integer syncrespflag;

	@MessageCheck(regular = "^\\d{1}$")
	public Integer transsyncver;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer priceversion;

	@MessageCheck(regular = "^\\d{1}$")
	public Integer ifunique;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer commnum;

	public String plattype;

	public String apptype;

	public String appchildtype;

	public Integer usefirstacid;

	public Integer usefirstacid2;

	public String devicetype;

	public Integer rsaversion;

	public String cppkey;

	public String cpvkey;

	public String platpkey;

	public String platvkey;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer groupid;

	public String appchinaappid;

	public String appchinaappkey;

	public String appchinapackage;

	@MessageCheck(regular = "^[0-9]*$")
	public Integer cusgroupid;

	public List<DistRule> distrules;

	public class DistRule extends RequestBody {
		@MessageCheck(con = OptionalEnum.M, regular = "^.{1,128}$")
		public String appid;

		@MessageCheck(con = OptionalEnum.M, regular = "^[0-9]*$")
		public Integer acid;

		@MessageCheck(con = OptionalEnum.M, regular = "^[0-9]*$")
		public Integer cpid;

		@MessageCheck(con = OptionalEnum.M, regular = "^[0-9]*$")
		public Integer platid;

		@MessageCheck(con = OptionalEnum.M)
		public Double distrate;

		public String getAppid() {
			return appid;
		}

		public void setAppid(String appid) {
			this.appid = appid;
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

		public Double getDistrate() {
			return distrate;
		}

		public void setDistrate(Double distrate) {
			this.distrate = distrate;
		}
	}

	public String getWaresid() {
		return waresid;
	}

	public void setWaresid(String waresid) {
		this.waresid = waresid;
	}

	public String getWaresname() {
		return waresname;
	}

	public void setWaresname(String waresname) {
		this.waresname = waresname;
	}

	public String getCpname() {
		return cpname;
	}

	public void setCpname(String cpname) {
		this.cpname = cpname;
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

	public Integer getPlatid() {
		return platid;
	}

	public void setPlatid(Integer platid) {
		this.platid = platid;
	}

	public String getApname() {
		return apname;
	}

	public void setApname(String apname) {
		this.apname = apname;
	}

	public String getWaresstatus() {
		return waresstatus;
	}

	public void setWaresstatus(String waresstatus) {
		this.waresstatus = waresstatus;
	}

	public Integer getVia() {
		return via;
	}

	public void setVia(Integer via) {
		this.via = via;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public String getWeresdesc() {
		return weresdesc;
	}

	public void setWeresdesc(String weresdesc) {
		this.weresdesc = weresdesc;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getServphone() {
		return servphone;
	}

	public void setServphone(String servphone) {
		this.servphone = servphone;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getOnlinetime() {
		return onlinetime;
	}

	public void setOnlinetime(Date onlinetime) {
		this.onlinetime = onlinetime;
	}

	public Date getOfflinetime() {
		return offlinetime;
	}

	public void setOfflinetime(Date offlinetime) {
		this.offlinetime = offlinetime;
	}

	public Date getLastupdtime() {
		return lastupdtime;
	}

	public void setLastupdtime(Date lastupdtime) {
		this.lastupdtime = lastupdtime;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getAppresppkey() {
		return appresppkey;
	}

	public void setAppresppkey(String appresppkey) {
		this.appresppkey = appresppkey;
	}

	public String getApprespvkey() {
		return apprespvkey;
	}

	public void setApprespvkey(String apprespvkey) {
		this.apprespvkey = apprespvkey;
	}

	public String getAppmodkey() {
		return appmodkey;
	}

	public void setAppmodkey(String appmodkey) {
		this.appmodkey = appmodkey;
	}

	public Integer getCacheflag() {
		return cacheflag;
	}

	public void setCacheflag(Integer cacheflag) {
		this.cacheflag = cacheflag;
	}

	public Integer getTranssyncflag() {
		return transsyncflag;
	}

	public void setTranssyncflag(Integer transsyncflag) {
		this.transsyncflag = transsyncflag;
	}

	public String getTranssyncaddr() {
		return transsyncaddr;
	}

	public void setTranssyncaddr(String transsyncaddr) {
		this.transsyncaddr = transsyncaddr;
	}

	public Integer getSyncrespflag() {
		return syncrespflag;
	}

	public void setSyncrespflag(Integer syncrespflag) {
		this.syncrespflag = syncrespflag;
	}

	public Integer getTranssyncver() {
		return transsyncver;
	}

	public void setTranssyncver(Integer transsyncver) {
		this.transsyncver = transsyncver;
	}

	public Integer getPriceversion() {
		return priceversion;
	}

	public void setPriceversion(Integer priceversion) {
		this.priceversion = priceversion;
	}

	public Integer getIfunique() {
		return ifunique;
	}

	public void setIfunique(Integer ifunique) {
		this.ifunique = ifunique;
	}

	public Integer getCommnum() {
		return commnum;
	}

	public void setCommnum(Integer commnum) {
		this.commnum = commnum;
	}

	public String getPlattype() {
		return plattype;
	}

	public void setPlattype(String plattype) {
		this.plattype = plattype;
	}

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public String getAppchildtype() {
		return appchildtype;
	}

	public void setAppchildtype(String appchildtype) {
		this.appchildtype = appchildtype;
	}

	public Integer getUsefirstacid() {
		return usefirstacid;
	}

	public void setUsefirstacid(Integer usefirstacid) {
		this.usefirstacid = usefirstacid;
	}

	public Integer getUsefirstacid2() {
		return usefirstacid2;
	}

	public void setUsefirstacid2(Integer usefirstacid2) {
		this.usefirstacid2 = usefirstacid2;
	}

	public String getDevicetype() {
		return devicetype;
	}

	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}

	public Integer getRsaversion() {
		return rsaversion;
	}

	public void setRsaversion(Integer rsaversion) {
		this.rsaversion = rsaversion;
	}

	public String getCppkey() {
		return cppkey;
	}

	public void setCppkey(String cppkey) {
		this.cppkey = cppkey;
	}

	public String getCpvkey() {
		return cpvkey;
	}

	public void setCpvkey(String cpvkey) {
		this.cpvkey = cpvkey;
	}

	public String getPlatpkey() {
		return platpkey;
	}

	public void setPlatpkey(String platpkey) {
		this.platpkey = platpkey;
	}

	public String getPlatvkey() {
		return platvkey;
	}

	public void setPlatvkey(String platvkey) {
		this.platvkey = platvkey;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}

	public String getAppchinaappid() {
		return appchinaappid;
	}

	public void setAppchinaappid(String appchinaappid) {
		this.appchinaappid = appchinaappid;
	}

	public String getAppchinaappkey() {
		return appchinaappkey;
	}

	public void setAppchinaappkey(String appchinaappkey) {
		this.appchinaappkey = appchinaappkey;
	}

	public String getAppchinapackage() {
		return appchinapackage;
	}

	public void setAppchinapackage(String appchinapackage) {
		this.appchinapackage = appchinapackage;
	}

	public Integer getCusgroupid() {
		return cusgroupid;
	}

	public void setCusgroupid(Integer cusgroupid) {
		this.cusgroupid = cusgroupid;
	}

	public List<DistRule> getDistrules() {
		return distrules;
	}

	public void setDistrules(List<DistRule> distrules) {
		this.distrules = distrules;
	}

}
