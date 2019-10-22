package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

public class SurveyAssetSave {

    @SerializedName("SurveyID")
    private String surveyID;

    @SerializedName("CompID")
    private String compID;

    @SerializedName("UnitID")
    private String unitID;

    @SerializedName("SurveyYear")
    private String surveyYear;

    @SerializedName("SurveyNo")
    private int surveyNo;

    @SerializedName("AssetID")
    private String assetID;

    @SerializedName("AssetStatus")
    private String assetStatus;

    @SerializedName("UnitIDOwner")
    private String unitIDOwner;

    @SerializedName("EmpNoOwner")
    private String empNoOwner;

    @SerializedName("LCompID")
    private String lCompID;

    @SerializedName("LUnitID")
    private String lUnitID;

    @SerializedName("ProvinceCode")
    private int provinceCode;

    @SerializedName("OfficeID")
    private String officeID;

    @SerializedName("ZoneID")
    private String zoneID;

    @SerializedName("Floor")
    private String floor;

    @SerializedName("ResultFound")
    private String resultFound;

    @SerializedName("ResultUnitOwner")
    private String resultUnitOwner;

    @SerializedName("ResultLocation")
    private String resultLocation;

    @SerializedName("SurveyActionResult")
    private String surveyActionResult;

    @SerializedName("SurveyRemark")
    private String surveyRemark;

    @SerializedName("SurveyBy")
    private String surveyBy;

    @Override
    public String toString(){
        return
                "SearchDocAssetDetail{" +
                        "SurveyID = '" + getSurveyID() + '\'' +
                        ",CompID = '" + getCompID() + '\'' +
                        ",UnitID = '" + getUnitID() + '\'' +
                        ",SurveyYear = '" + getSurveyYear() + '\'' +
                        ",SurveyNo = '" + getSurveyNo() + '\'' +
                        ",AssetID = '" + getAssetID() + '\'' +
                        ",AssetStatus = '" + getAssetStatus() + '\'' +
                        ",UnitIDOwner = '" + getUnitIDOwner() + '\'' +
                        ",EmpNoOwner = '" + getEmpNoOwner() + '\'' +
                        ",LCompID = '" + getlCompID() + '\'' +
                        ",LUnitID = '" + getlUnitID() + '\'' +
                        ",ProvinceCode = '" + getProvinceCode() + '\'' +
                        ",OfficeID = '" + getOfficeID() + '\'' +
                        ",ZoneID = '" + getZoneID() + '\'' +
                        ",Floor = '" + getFloor() + '\'' +
                        ",ResultFound = '" + getResultFound() + '\'' +
                        ",ResultUnitOwner = '" + getResultUnitOwner() + '\'' +
                        ",ResultLocation = '" + getResultLocation() + '\'' +
                        ",SurveyActionResult = '" + getSurveyActionResult() + '\'' +
                        ",SurveyRemark = '" + getSurveyRemark() + '\'' +
                        ",SurveyBy = '" + getSurveyBy() + '\'' +
                        "}";
    }

    public String getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(String surveyID) {
        this.surveyID = surveyID;
    }

    public String getCompID() {
        return compID;
    }

    public void setCompID(String compID) {
        this.compID = compID;
    }

    public String getUnitID() {
        return unitID;
    }

    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

    public String getSurveyYear() {
        return surveyYear;
    }

    public void setSurveyYear(String surveyYear) {
        this.surveyYear = surveyYear;
    }

    public int getSurveyNo() {
        return surveyNo;
    }

    public void setSurveyNo(int surveyNo) {
        this.surveyNo = surveyNo;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getUnitIDOwner() {
        return unitIDOwner;
    }

    public void setUnitIDOwner(String unitIDOwner) {
        this.unitIDOwner = unitIDOwner;
    }

    public String getEmpNoOwner() {
        return empNoOwner;
    }

    public void setEmpNoOwner(String empNoOwner) {
        this.empNoOwner = empNoOwner;
    }

    public String getlCompID() {
        return lCompID;
    }

    public void setlCompID(String lCompID) {
        this.lCompID = lCompID;
    }

    public String getlUnitID() {
        return lUnitID;
    }

    public void setlUnitID(String lUnitID) {
        this.lUnitID = lUnitID;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getOfficeID() {
        return officeID;
    }

    public void setOfficeID(String officeID) {
        this.officeID = officeID;
    }

    public String getZoneID() {
        return zoneID;
    }

    public void setZoneID(String zoneID) {
        this.zoneID = zoneID;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floorID) {
        this.floor = floorID;
    }

    public String getResultFound() {
        return resultFound;
    }

    public void setResultFound(String resultFound) {
        this.resultFound = resultFound;
    }

    public String getResultUnitOwner() {
        return resultUnitOwner;
    }

    public void setResultUnitOwner(String resultUnitOwner) {
        this.resultUnitOwner = resultUnitOwner;
    }

    public String getResultLocation() {
        return resultLocation;
    }

    public void setResultLocation(String resultLocation) {
        this.resultLocation = resultLocation;
    }

    public String getSurveyActionResult() {
        return surveyActionResult;
    }

    public void setSurveyActionResult(String surveyActionResult) {
        this.surveyActionResult = surveyActionResult;
    }

    public String getSurveyRemark() {
        return surveyRemark;
    }

    public void setSurveyRemark(String surveyRemark) {
        this.surveyRemark = surveyRemark;
    }

    public String getSurveyBy() {
        return surveyBy;
    }

    public void setSurveyBy(String surveyBy) {
        this.surveyBy = surveyBy;
    }
}
