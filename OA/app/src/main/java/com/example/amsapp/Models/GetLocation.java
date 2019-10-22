package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GetLocation implements Serializable {

	@SerializedName("SurveyYear")
	private String surveyYear;

	@SerializedName("SurveyID")
	private String surveyID;

	@SerializedName("SurveyCompID")
	private String surveyCompID;

	@SerializedName("SurveyUnitID")
	private String surveyUnitID;

	@SerializedName("SurveyNo")
	private int surveyNo;

	@SerializedName("LoCompID")
	private String loCompID;

	@SerializedName("LoCompCode")
	private String loCompCode;

	@SerializedName("LocationUnitID")
	private String locationUnitID;

	@SerializedName("LocationUnitCode")
	private String locationUnitCode;

	@SerializedName("ProvinceID")
	private int provinceID;

	@SerializedName("ProvinceName")
	private String provinceName;

	@SerializedName("OfficeID")
	private String officeID;

	@SerializedName("OfficeName")
	private String officeName;

	@SerializedName("ZoneID")
	private String zoneID;

	@SerializedName("ZoneName")
	private String zoneName;

	@SerializedName("FloorID")
	private String floorID;

	@SerializedName("FloorName")
	private String floorName;

	@SerializedName("LocationName")
	private String locationName;

	@SerializedName("AssetInPlan_Y")
	private String assetInPlan_Y;

	@SerializedName("AssetInPlan_N")
	private String assetInPlan_N;

	@SerializedName("AssetSurvey_Y")
	private String assetSurvey_Y;

	@SerializedName("AssetSurvey_N")
	private String assetSurvey_N;

	@SerializedName("AssetFound_Y")
	private String assetFound_Y;

	@SerializedName("AssetFound_N")
	private String assetFound_N;

	@SerializedName("AssetUnitMatch_Y")
	private String assetUnitMatch_Y;

	@SerializedName("AssetUnitMatch_N")
	private String assetUnitMatch_N;

	@SerializedName("AssetLocationMatch_Y")
	private String assetLocationMatch_Y;

	@SerializedName("AssetLocationMatch_N")
	private String assetLocationMatch_N;

	public String getSurveyYear() { return surveyYear; }

	public void setSurveyYear(String surveyYear) { this.surveyYear = surveyYear; }

	public String getSurveyID() { return surveyID; }

	public void setSurveyID(String surveyID) { this.surveyID = surveyID; }

	public String getSurveyCompID() { return surveyCompID; }

	public void setSurveyCompID(String surveyCompID) { this.surveyCompID = surveyCompID; }

	public String getSurveyUnitID() { return surveyUnitID; }

	public void setSurveyUnitID(String surveyUnitID) { this.surveyUnitID = surveyUnitID; }

	public int getSurveyNo() { return surveyNo; }

	public void setSurveyNo(int surveyNo) { this.surveyNo = surveyNo; }

	public String getLoCompID() { return loCompID; }

	public void setLoCompID(String loCompID) { this.loCompID = loCompID; }

	public String getLoCompCode() { return loCompCode; }

	public void setLoCompCode(String loCompCode) { this.loCompCode = loCompCode; }

	public String getLocationUnitID() { return locationUnitID; }

	public void setLocationUnitID(String locationUnitID) { this.locationUnitID = locationUnitID; }

	public String getLocationUnitCode() { return locationUnitCode; }

	public void setLocationUnitCode(String locationUnitCode) { this.locationUnitCode = locationUnitCode; }

	public int getProvinceID() { return provinceID; }

	public void setProvinceID(int provinceID) { this.provinceID = provinceID; }

	public String getProvinceName() { return provinceName; }

	public void setProvinceName(String provinceName) { this.provinceName = provinceName; }

	public String getOfficeID() { return officeID; }

	public void setOfficeID(String officeID) {this.officeID = officeID; }

	public String getOfficeName() { return officeName; }

	public void setOfficeName(String officeName) { this.officeName = officeName; }

	public String getZoneID() { return zoneID; }

	public void setZoneID(String zoneID) { this.zoneID = zoneID; }

	public String getZoneName() { return zoneName; }

	public void setZoneName(String zoneName) { this.zoneName = zoneName; }

	public String getFloorID() { return floorID; }

	public void setFloorID(String floorID) { this.floorID = floorID; }

	public String getFloorName() { return floorName; }

	public void setFloorName(String floorName) { this.floorName = floorName; }

	public String getLocationName() { return locationName; }

	public void setLocationName(String locationName) { this.locationName = locationName; }

	public String getAssetInPlan_Y() { return assetInPlan_Y; }

	public void setAssetInPlan_Y(String assetInPlan_Y) { this.assetInPlan_Y = assetInPlan_Y; }

	public String getAssetInPlan_N() { return assetInPlan_N; }

	public void setAssetInPlan_N(String assetInPlan_N) { this.assetInPlan_N = assetInPlan_N; }

	public String getAssetSurvey_Y() { return assetSurvey_Y; }

	public void setAssetSurvey_Y(String assetSurvey_Y) { this.assetSurvey_Y = assetSurvey_Y; }

	public String getAssetSurvey_N() { return assetSurvey_N; }

	public void setAssetSurvey_N(String assetSurvey_N) { this.assetSurvey_N = assetSurvey_N; }

	public String getAssetFound_Y() { return assetFound_Y; }

	public void setAssetFound_Y(String assetFound_Y) { this.assetFound_Y = assetFound_Y; }

	public String getAssetFound_N() { return assetFound_N; }

	public void setAssetFound_N(String assetFound_N) { this.assetFound_N = assetFound_N; }

	public String getAssetUnitMatch_Y() { return assetUnitMatch_Y; }

	public void setAssetUnitMatch_Y(String assetUnitMatch_Y) { this.assetUnitMatch_Y = assetUnitMatch_Y; }

	public String getAssetUnitMatch_N() { return assetUnitMatch_N; }

	public void setAssetUnitMatch_N(String assetUnitMatch_N) { this.assetUnitMatch_N = assetUnitMatch_N; }

	public String getAssetLocationMatch_Y() { return assetLocationMatch_Y; }

	public void setAssetLocationMatch_Y(String assetLocationMatch_Y) { this.assetLocationMatch_Y = assetLocationMatch_Y; }

	public String getAssetLocationMatch_N() { return assetLocationMatch_N; }

	public void setAssetLocationMatch_N(String assetLocationMatch_N) { this.assetLocationMatch_N = assetLocationMatch_N;
	}
}