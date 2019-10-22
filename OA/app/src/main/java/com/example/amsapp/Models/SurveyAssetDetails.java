package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

public class SurveyAssetDetails {

    @SerializedName("SurveyID")
    private String surveyID;

    @SerializedName("CompID")
    private String compID;

    @SerializedName("SurveyUnitId")
    private String surveyUnitId;

    @SerializedName("SurveyYear")
    private int surveyYear;

    @SerializedName("SurveyNo")
    private String surveyNo;

    @SerializedName("AssetID")
    private String assetID;

    @SerializedName("AssetName")
    private String assetName;

    @SerializedName("SerialNo")
    private String serialNo;

    @SerializedName("LCompID")
    private String lCompID;

    @SerializedName("LUnitID")
    private String lUnitID;

    @SerializedName("Province")
    private int province;

    @SerializedName("OfficeID")
    private String officeID;

    @SerializedName("ZoneID")
    private String zoneID;

    @SerializedName("FloorID")
    private String floorID;

    @SerializedName("Updby")
    private String updby;

    @Override
    public String toString(){
        return
                "SearchDocAssetDetail{" +
                        "SurveyID = '" + getSurveyID() + '\'' +
                        ",CompID = '" + getCompID() + '\'' +
                        ",SurveyUnitId = '" + getSurveyUnitId() + '\'' +
                        ",SurveyYear = '" + getSurveyYear() + '\'' +
                        ",SurveyNo = '" + getSurveyNo() + '\'' +
                        ",AssetID = '" + getAssetID() + '\'' +
                        ",AssetName = '" + null + '\'' +
                        ",SerialNo = '" + null + '\'' +
                        ",LCompID = '" + getlCompID() + '\'' +
                        ",LUnitID = '" + getlUnitID() + '\'' +
                        ",Province = '" + getProvince() + '\'' +
                        ",OfficeID = '" + getOfficeID() + '\'' +
                        ",ZoneID = '" + getZoneID() + '\'' +
                        ",FloorID = '" + getFloorID() + '\'' +
                        ",Updby = '" + getUpdby() + '\'' +
                        "}";
    }

    public String getSurveyID() { return surveyID; }

    public void setSurveyID(String surveyID) { this.surveyID = surveyID; }

    public String getCompID() { return compID; }

    public void setCompID(String compID) { this.compID = compID; }

    public String getSurveyUnitId() { return surveyUnitId; }

    public void setSurveyUnitId(String surveyUnitId) { this.surveyUnitId = surveyUnitId; }

    public int getSurveyYear() { return surveyYear; }

    public void setSurveyYear(int surveyYear) { this.surveyYear = surveyYear; }

    public String getSurveyNo() { return surveyNo; }

    public void setSurveyNo(String surveyNo) { this.surveyNo = surveyNo; }

    public String getAssetID() { return assetID; }

    public void setAssetID(String assetID) { this.assetID = assetID; }

    public String getAssetName() { return assetName; }

    public void setAssetName(String assetName) { this.assetName = assetName; }

    public String getSerialNo() { return serialNo; }

    public void setSerialNo(String serialNo) { this.serialNo = serialNo; }

    public String getlCompID() { return lCompID; }

    public void setlCompID(String lCompID) { this.lCompID = lCompID; }

    public String getlUnitID() { return lUnitID; }

    public void setlUnitID(String lUnitID) { this.lUnitID = lUnitID; }

    public int getProvince() { return province; }

    public void setProvince(int province) { this.province = province; }

    public String getOfficeID() { return officeID; }

    public void setOfficeID(String officeID) { this.officeID = officeID; }

    public String getZoneID() { return zoneID; }

    public void setZoneID(String zoneID) { this.zoneID = zoneID; }

    public String getFloorID() { return floorID; }

    public void setFloorID(String floorID) { this.floorID = floorID; }

    public String getUpdby() { return updby; }

    public void setUpdby(String updby) { this.updby = updby; }
}
