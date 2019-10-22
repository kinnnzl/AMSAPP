package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Data implements Serializable {

	@SerializedName("EmpOwner")
	private String empOwner;

	@SerializedName("UnitOwner")
	private String unitOwner;

	@SerializedName("FloorName")
	private String floorName;

	@SerializedName("AssetStatus")
	private String assetStatus;

	@SerializedName("OASubCateID")
	private String oASubCateID;

	@SerializedName("ProvinceName")
	private String provinceName;

	@SerializedName("ZoneName")
	private String zoneName;

	@SerializedName("UnitCode")
	private String unitCode;

	@SerializedName("compcde")
	private String compcde;

	@SerializedName("RcvDate")
	private String rcvDate;

	@SerializedName("AssetCodeType")
	private String assetCodeType;

	@SerializedName("SerialNo")
	private String serialNo;

	@SerializedName("Floor")
	private String floor;

	@SerializedName("TmpAssetID")
	private String tmpAssetID;

	@SerializedName("ZoneId")
	private String zoneId;

	@SerializedName("AssetTypeThaiName")
	private String assetTypeThaiName;

	@SerializedName("OfficeId")
	private String officeId;

	@SerializedName("LCompID")
	private String lCompID;

	@SerializedName("OASubCateName")
	private String oASubCateName;

	@SerializedName("CompID")
	private String compID;

	@SerializedName("AssetName")
	private String assetName;

	@SerializedName("AssetStatusDesc")
	private String assetStatusDesc;

	@SerializedName("LUnitID")
	private String lUnitID;

	@SerializedName("QRCode")
	private String qRCode;

	@SerializedName("UnitID")
	private String unitID;

	@SerializedName("AccCateID")
	private String accCateID;

	@SerializedName("EmpNo")
	private String empNo;

	@SerializedName("AssetTypeEngName")
	private String assetTypeEngName;

	@SerializedName("ProvinceCode")
	private int provinceCode;

	@SerializedName("AccCateDesc")
	private String accCateDesc;

	@SerializedName("PoType")
	private String poType;

	@SerializedName("OfficeName")
	private String officeName;

	public void setEmpOwner(String empOwner){
		this.empOwner = empOwner;
	}

	public String getEmpOwner(){
		return empOwner;
	}

	public void setUnitOwner(String unitOwner){
		this.unitOwner = unitOwner;
	}

	public String getUnitOwner(){
		return unitOwner;
	}

	public void setFloorName(String floorName){
		this.floorName = floorName;
	}

	public String getFloorName(){
		return floorName;
	}

	public void setAssetStatus(String assetStatus){
		this.assetStatus = assetStatus;
	}

	public String getAssetStatus(){
		return assetStatus;
	}

	public void setOASubCateID(String oASubCateID){
		this.oASubCateID = oASubCateID;
	}

	public String getOASubCateID(){
		return oASubCateID;
	}

	public void setProvinceName(String provinceName){
		this.provinceName = provinceName;
	}

	public String getProvinceName(){
		return provinceName;
	}

	public void setZoneName(String zoneName){
		this.zoneName = zoneName;
	}

	public String getZoneName(){
		return zoneName;
	}

	public void setUnitCode(String unitCode){
		this.unitCode = unitCode;
	}

	public String getUnitCode(){
		return unitCode;
	}

	public void setCompcde(String compcde){
		this.compcde = compcde;
	}

	public String getCompcde(){
		return compcde;
	}

	public void setRcvDate(String rcvDate){
		this.rcvDate = rcvDate;
	}

	public String getRcvDate(){
		return rcvDate;
	}

	public void setAssetCodeType(String assetCodeType){
		this.assetCodeType = assetCodeType;
	}

	public String getAssetCodeType(){
		return assetCodeType;
	}

	public void setSerialNo(String serialNo){
		this.serialNo = serialNo;
	}

	public String getSerialNo(){
		return serialNo;
	}

	public void setFloor(String floor){
		this.floor = floor;
	}

	public String getFloor(){
		return floor;
	}

	public void setTmpAssetID(String tmpAssetID){
		this.tmpAssetID = tmpAssetID;
	}

	public String getTmpAssetID(){
		return tmpAssetID;
	}

	public void setZoneId(String zoneId){
		this.zoneId = zoneId;
	}

	public String getZoneId(){
		return zoneId;
	}

	public void setAssetTypeThaiName(String assetTypeThaiName){
		this.assetTypeThaiName = assetTypeThaiName;
	}

	public String getAssetTypeThaiName(){
		return assetTypeThaiName;
	}

	public void setOfficeId(String officeId){
		this.officeId = officeId;
	}

	public String getOfficeId(){
		return officeId;
	}

	public void setLCompID(String lCompID){
		this.lCompID = lCompID;
	}

	public String getLCompID(){
		return lCompID;
	}

	public void setOASubCateName(String oASubCateName){
		this.oASubCateName = oASubCateName;
	}

	public String getOASubCateName(){
		return oASubCateName;
	}

	public void setCompID(String compID){
		this.compID = compID;
	}

	public String getCompID(){
		return compID;
	}

	public void setAssetName(String assetName){
		this.assetName = assetName;
	}

	public String getAssetName(){
		return assetName;
	}

	public void setAssetStatusDesc(String assetStatusDesc){
		this.assetStatusDesc = assetStatusDesc;
	}

	public String getAssetStatusDesc(){
		return assetStatusDesc;
	}

	public void setLUnitID(String lUnitID){
		this.lUnitID = lUnitID;
	}

	public String getLUnitID(){
		return lUnitID;
	}

	public void setQRCode(String qRCode){
		this.qRCode = qRCode;
	}

	public String getQRCode(){
		return qRCode;
	}

	public void setUnitID(String unitID){
		this.unitID = unitID;
	}

	public String getUnitID(){
		return unitID;
	}

	public void setAccCateID(String accCateID){
		this.accCateID = accCateID;
	}

	public String getAccCateID(){
		return accCateID;
	}

	public void setEmpNo(String empNo){
		this.empNo = empNo;
	}

	public String getEmpNo(){
		return empNo;
	}

	public void setAssetTypeEngName(String assetTypeEngName){
		this.assetTypeEngName = assetTypeEngName;
	}

	public String getAssetTypeEngName(){
		return assetTypeEngName;
	}

	public void setProvinceCode(int provinceCode){
		this.provinceCode = provinceCode;
	}

	public int getProvinceCode(){
		return provinceCode;
	}

	public void setAccCateDesc(String accCateDesc){
		this.accCateDesc = accCateDesc;
	}

	public String getAccCateDesc(){
		return accCateDesc;
	}

	public void setPoType(String poType){
		this.poType = poType;
	}

	public String getPoType(){
		return poType;
	}

	public void setOfficeName(String officeName){
		this.officeName = officeName;
	}

	public String getOfficeName(){
		return officeName;
	}
}