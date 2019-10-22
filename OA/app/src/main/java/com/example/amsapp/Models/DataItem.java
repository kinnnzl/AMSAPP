package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataItem implements Serializable {

	@SerializedName("DummyOfUnitID")
	private Object dummyOfUnitID;

	@SerializedName("DummyUnit")
	private boolean dummyUnit;

	@SerializedName("unittname")
	private String unittname;

	@SerializedName("unitename")
	private String unitename;

	@SerializedName("startdate")
	private String startdate;

	@SerializedName("servcde")
	private String servcde;

	@SerializedName("upddate")
	private String upddate;

	@SerializedName("UnitCode")
	private String unitCode;

	@SerializedName("OldUnitCode")
	private String oldUnitCode;

	@SerializedName("compid")
	private String compid;

	@SerializedName("Permission")
	private boolean permission;

	@SerializedName("orglevid")
	private String orglevid;

	@SerializedName("funcdesc")
	private String funcdesc;

	@SerializedName("timestamp")
	private String timestamp;

	@SerializedName("unitlev2")
	private String unitlev2;

	@SerializedName("unitlev1")
	private String unitlev1;

	@SerializedName("unitlev4")
	private String unitlev4;

	@SerializedName("realOrglevid")
	private Object realOrglevid;

	@SerializedName("unitlev3")
	private String unitlev3;

	@SerializedName("visible")
	private boolean visible;

	@SerializedName("unitlev6")
	private String unitlev6;

	@SerializedName("unitlev5")
	private String unitlev5;

	@SerializedName("updby")
	private String updby;

	@SerializedName("active")
	private boolean active;

	@SerializedName("aliasname")
	private String aliasname;

	@SerializedName("mngid")
	private String mngid;

	@SerializedName("isPillar")
	private Object isPillar;

	@SerializedName("ParentUnitID")
	private String parentUnitID;

	@SerializedName("ChildData")
	private Object childData;

	@SerializedName("unitid")
	private String unitid;

	public void setDummyOfUnitID(Object dummyOfUnitID){
		this.dummyOfUnitID = dummyOfUnitID;
	}

	public Object getDummyOfUnitID(){
		return dummyOfUnitID;
	}

	public void setDummyUnit(boolean dummyUnit){
		this.dummyUnit = dummyUnit;
	}

	public boolean isDummyUnit(){
		return dummyUnit;
	}

	public void setUnittname(String unittname){
		this.unittname = unittname;
	}

	public String getUnittname(){
		return unittname;
	}

	public void setUnitename(String unitename){
		this.unitename = unitename;
	}

	public String getUnitename(){
		return unitename;
	}

	public void setStartdate(String startdate){
		this.startdate = startdate;
	}

	public String getStartdate(){
		return startdate;
	}

	public void setServcde(String servcde){
		this.servcde = servcde;
	}

	public String getServcde(){
		return servcde;
	}

	public void setUpddate(String upddate){
		this.upddate = upddate;
	}

	public String getUpddate(){
		return upddate;
	}

	public void setUnitCode(String unitCode){
		this.unitCode = unitCode;
	}

	public String getUnitCode(){
		return unitCode;
	}

	public void setOldUnitCode(String oldUnitCode){
		this.oldUnitCode = oldUnitCode;
	}

	public String getOldUnitCode(){
		return oldUnitCode;
	}

	public void setCompid(String compid){
		this.compid = compid;
	}

	public String getCompid(){
		return compid;
	}

	public void setPermission(boolean permission){
		this.permission = permission;
	}

	public boolean isPermission(){
		return permission;
	}

	public void setOrglevid(String orglevid){
		this.orglevid = orglevid;
	}

	public String getOrglevid(){
		return orglevid;
	}

	public void setFuncdesc(String funcdesc){
		this.funcdesc = funcdesc;
	}

	public String getFuncdesc(){
		return funcdesc;
	}

	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}

	public String getTimestamp(){
		return timestamp;
	}

	public void setUnitlev2(String unitlev2){
		this.unitlev2 = unitlev2;
	}

	public String getUnitlev2(){
		return unitlev2;
	}

	public void setUnitlev1(String unitlev1){
		this.unitlev1 = unitlev1;
	}

	public String getUnitlev1(){
		return unitlev1;
	}

	public void setUnitlev4(String unitlev4){
		this.unitlev4 = unitlev4;
	}

	public String getUnitlev4(){
		return unitlev4;
	}

	public void setRealOrglevid(Object realOrglevid){
		this.realOrglevid = realOrglevid;
	}

	public Object getRealOrglevid(){
		return realOrglevid;
	}

	public void setUnitlev3(String unitlev3){
		this.unitlev3 = unitlev3;
	}

	public String getUnitlev3(){
		return unitlev3;
	}

	public void setVisible(boolean visible){
		this.visible = visible;
	}

	public boolean isVisible(){
		return visible;
	}

	public void setUnitlev6(String unitlev6){
		this.unitlev6 = unitlev6;
	}

	public String getUnitlev6(){
		return unitlev6;
	}

	public void setUnitlev5(String unitlev5){
		this.unitlev5 = unitlev5;
	}

	public String getUnitlev5(){
		return unitlev5;
	}

	public void setUpdby(String updby){
		this.updby = updby;
	}

	public String getUpdby(){
		return updby;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setAliasname(String aliasname){
		this.aliasname = aliasname;
	}

	public String getAliasname(){
		return aliasname;
	}

	public void setMngid(String mngid){
		this.mngid = mngid;
	}

	public String getMngid(){
		return mngid;
	}

	public void setIsPillar(Object isPillar){
		this.isPillar = isPillar;
	}

	public Object getIsPillar(){
		return isPillar;
	}

	public void setParentUnitID(String parentUnitID){
		this.parentUnitID = parentUnitID;
	}

	public String getParentUnitID(){
		return parentUnitID;
	}

	public void setChildData(Object childData){
		this.childData = childData;
	}

	public Object getChildData(){
		return childData;
	}

	public void setUnitid(String unitid){
		this.unitid = unitid;
	}

	public String getUnitid(){
		return unitid;
	}
}