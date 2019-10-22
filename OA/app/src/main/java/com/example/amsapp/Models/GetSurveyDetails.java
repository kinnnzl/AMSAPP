package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetSurveyDetails implements Serializable {

    @SerializedName("SurveyID")
    private String surveyID;

    @SerializedName("CompID")
    private String compID;

    @SerializedName("CompCode")
    private String compCode;

    @SerializedName("UnitIDOwner")
    private String unitIDOwner;

    @SerializedName("UnitCodeOwner")
    private String unitCodeOwner;

    @SerializedName("SurveyYear")
    private String surveyYear;

    @SerializedName("SurveyNo")
    private String surveyNo;

    @SerializedName("EmpNoOwner")
    private String empNoOwner;

    @SerializedName("EmpNameOwner")
    private String empNameOwner;

    @SerializedName("AssetID")
    private String assetID;

    @SerializedName("SerialNo")
    private String serialNo;

    @SerializedName("AssetName")
    private String assetName;

    @SerializedName("RcvDate")
    private String rcvDate;

    @SerializedName("AssetStatus")
    private String assetStatus;

    @SerializedName("AssetStatusDesc")
    private String assetStatusDesc;

    @SerializedName("BookValue")
    private double bookValue;

    @SerializedName("ItemCode")
    private String itemCode;

    @SerializedName("OA_CODE")
    private String oA_CODE;

    @SerializedName("ACC_CODE")
    private String aCC_CODE;

    @SerializedName("ASSETTYPE_CODE")
    private String aSSETTYPE_CODE;

    @SerializedName("OA_NAME")
    private String oA_NAME;

    @SerializedName("ACC_NAME")
    private String aCC_NAME;

    @SerializedName("ASSETTYPE_NAME")
    private String aSSETTYPE_NAME;

    @SerializedName("ProvinceCode")
    private int provinceCode;

    @SerializedName("ProvinceName")
    private String provinceName;

    @SerializedName("OfficeId")
    private String officeId;

    @SerializedName("OfficeName")
    private String officeName;

    @SerializedName("LCompID")
    private String lCompID;

    @SerializedName("compcde")
    private String compcde;

    @SerializedName("ZoneId")
    private String zoneId;

    @SerializedName("ZoneName")
    private String zoneName;

    @SerializedName("LUnitID")
    private String lUnitID;

    @SerializedName("LUnitCode")
    private String lUnitCode;

    @SerializedName("Floor")
    private String floor;

    @SerializedName("FloorName")
    private String floorName;

    @SerializedName("QRCode")
    private String qRCode;

    @SerializedName("CategoryID")
    private String categoryID;

    @SerializedName("IconType")
    private String iconType;

    @SerializedName("CountScan")
    private int countScan;

    @SerializedName("FoundAsset")
    private String foundAsset;

    @SerializedName("FoundAssetDesc")
    private String foundAssetDesc;

    @SerializedName("UnitIDMatch")
    private String unitIDMatch;

    @SerializedName("UnitIDMatchDesc")
    private String unitIDMatchDesc;

    @SerializedName("LocationMatch")
    private String locationMatch;

    @SerializedName("LocationMatchDesc")
    private String locationMatchDesc;

    @SerializedName("SurveyBy")
    private String surveyBy;

    @SerializedName("SurveyDate")
    private String surveyDate;

    @SerializedName("SurveyRemark")
    private String surveyRemark;

    @SerializedName("AssetInPlan")
    private boolean assetInPlan;

    @SerializedName("IsSurvey")
    private boolean isSurvey;

    @SerializedName("Popup")
    private String popup;

    @SerializedName("Message")
    private String message;

    public String getSurveyID() { return surveyID; }

    public void setSurveyID(String surveyID) { this.surveyID = surveyID; }

    public String getCompID() { return compID; }

    public void setCompID(String compID) { this.compID = compID; }

    public String getCompCode() { return compCode; }

    public void setCompCode(String compCode) { this.compCode = compCode; }

    public String getUnitIDOwner() { return unitIDOwner; }

    public void setUnitIDOwner(String unitIDOwner) { this.unitIDOwner = unitIDOwner; }

    public String getUnitCodeOwner() { return unitCodeOwner; }

    public void setUnitCodeOwner(String unitCodeOwner) { this.unitCodeOwner = unitCodeOwner; }

    public String getSurveyYear() { return surveyYear; }

    public void setSurveyYear(String surveyYear) { this.surveyYear = surveyYear; }

    public String getSurveyNo() { return surveyNo; }

    public void setSurveyNo(String surveyNo) { this.surveyNo = surveyNo; }

    public String getEmpNoOwner() { return empNoOwner; }

    public void setEmpNoOwner(String empNoOwner) { this.empNoOwner = empNoOwner; }

    public String getEmpNameOwner() { return empNameOwner; }

    public void setEmpNameOwner(String empNameOwner) { this.empNameOwner = empNameOwner; }

    public String getAssetID() { return assetID; }

    public void setAssetID(String assetID) { this.assetID = assetID; }

    public String getSerialNo() { return serialNo; }

    public void setSerialNo(String serialNo) { this.serialNo = serialNo; }

    public String getAssetName() { return assetName; }

    public void setAssetName(String assetName) { this.assetName = assetName; }

    public String getRcvDate() { return rcvDate; }

    public void setRcvDate(String rcvDate) { this.rcvDate = rcvDate; }

    public String getAssetStatus() { return assetStatus; }

    public void setAssetStatus(String assetStatus) { this.assetStatus = assetStatus; }

    public String getAssetStatusDesc() { return assetStatusDesc; }

    public void setAssetStatusDesc(String assetStatusDesc) { this.assetStatusDesc = assetStatusDesc; }

    public double getBookValue() { return bookValue; }

    public void setBookValue(double bookValue) { this.bookValue = bookValue; }

    public String getItemCode() { return itemCode; }

    public void setItemCode(String itemCode) { this.itemCode = itemCode; }

    public String getoA_CODE() { return oA_CODE; }

    public void setoA_CODE(String oA_CODE) { this.oA_CODE = oA_CODE; }

    public String getaCC_CODE() { return aCC_CODE; }

    public void setaCC_CODE(String aCC_CODE) { this.aCC_CODE = aCC_CODE; }

    public String getaSSETTYPE_CODE() { return aSSETTYPE_CODE; }

    public void setaSSETTYPE_CODE(String aSSETTYPE_CODE) { this.aSSETTYPE_CODE = aSSETTYPE_CODE; }

    public String getoA_NAME() { return oA_NAME; }

    public void setoA_NAME(String oA_NAME) { this.oA_NAME = oA_NAME; }

    public String getaCC_NAME() { return aCC_NAME; }

    public void setaCC_NAME(String aCC_NAME) { this.aCC_NAME = aCC_NAME; }

    public String getaSSETTYPE_NAME() { return aSSETTYPE_NAME; }

    public void setaSSETTYPE_NAME(String aSSETTYPE_NAME) { this.aSSETTYPE_NAME = aSSETTYPE_NAME; }

    public int getProvinceCode() { return provinceCode; }

    public void setProvinceCode(int provinceCode) { this.provinceCode = provinceCode; }

    public String getProvinceName() { return provinceName; }

    public void setProvinceName(String provinceName) { this.provinceName = provinceName; }

    public String getOfficeId() { return officeId; }

    public void setOfficeId(String officeId) { this.officeId = officeId; }

    public String getOfficeName() { return officeName; }

    public void setOfficeName(String officeName) { this.officeName = officeName; }

    public String getlCompID() { return lCompID; }

    public void setlCompID(String lCompID) { this.lCompID = lCompID; }

    public String getCompcde() { return compcde; }

    public void setCompcde(String compcde) { this.compcde = compcde; }

    public String getZoneId() { return zoneId; }

    public void setZoneId(String zoneId) { this.zoneId = zoneId; }

    public String getZoneName() { return zoneName; }

    public void setZoneName(String zoneName) { this.zoneName = zoneName; }

    public String getlUnitID() { return lUnitID; }

    public void setlUnitID(String lUnitID) { this.lUnitID = lUnitID; }

    public String getlUnitCode() { return lUnitCode; }

    public void setlUnitCode(String lUnitCode) { this.lUnitCode = lUnitCode; }

    public String getFloor() { return floor; }

    public void setFloor(String floor) { this.floor = floor; }

    public String getFloorName() { return floorName; }

    public void setFloorName(String floorName) { this.floorName = floorName; }

    public String getqRCode() { return qRCode; }

    public void setqRCode(String qRCode) { this.qRCode = qRCode; }

    public String getCategoryID() { return categoryID; }

    public void setCategoryID(String categoryID) { this.categoryID = categoryID; }

    public String getIconType() { return iconType; }

    public void setIconType(String iconType) { this.iconType = iconType; }

    public int getCountScan() { return countScan; }

    public void setCountScan(int countScan) { this.countScan = countScan; }

    public String getFoundAsset() { return foundAsset; }

    public void setFoundAsset(String foundAsset) { this.foundAsset = foundAsset; }

    public String getFoundAssetDesc() { return foundAssetDesc; }

    public void setFoundAssetDesc(String foundAssetDesc) { this.foundAssetDesc = foundAssetDesc; }

    public String getUnitIDMatch() { return unitIDMatch; }

    public void setUnitIDMatch(String unitIDMatch) { this.unitIDMatch = unitIDMatch; }

    public String getUnitIDMatchDesc() { return unitIDMatchDesc; }

    public void setUnitIDMatchDesc(String unitIDMatchDesc) { this.unitIDMatchDesc = unitIDMatchDesc; }

    public String getLocationMatch() { return locationMatch; }

    public void setLocationMatch(String locationMatch) { this.locationMatch = locationMatch; }

    public String getLocationMatchDesc() { return locationMatchDesc; }

    public void setLocationMatchDesc(String locationMatchDesc) { this.locationMatchDesc = locationMatchDesc; }

    public String getSurveyBy() { return surveyBy; }

    public void setSurveyBy(String surveyBy) { this.surveyBy = surveyBy; }

    public String getSurveyDate() { return surveyDate; }

    public void setSurveyDate(String surveyDate) { this.surveyDate = surveyDate; }

    public String getSurveyRemark() { return surveyRemark; }

    public void setSurveyRemark(String surveyRemark) { this.surveyRemark = surveyRemark; }

    public boolean getAssetInPlan() { return assetInPlan; }

    public void setAssetInPlan(boolean assetInPlan) { this.assetInPlan = assetInPlan; }

    public boolean getIsSurvey() { return isSurvey; }

    public void setIsSurvey(boolean isSurvey) { this.isSurvey = isSurvey; }

    public String getPopup() { return popup; }

    public void setPopup(String popup) { this.popup = popup; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}
