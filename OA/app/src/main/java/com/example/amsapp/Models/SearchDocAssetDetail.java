package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class SearchDocAssetDetail implements Serializable {

    @SerializedName("CompID")
    private String compID;

    @SerializedName("UnitID")
    private String unitID;

    @SerializedName("SurveyYear")
    private String surveyYear;

    @SerializedName("SurveyNo")
    private String surveyNo;

    @Override
    public String toString(){
        return
                "SearchDocAssetDetail{" +
                        "CompID = '" + getCompID() + '\'' +
                        ",UnitID = '" + getUnitID() + '\'' +
                        ",SurveyYear = '" + getSurveyYear() + '\'' +
                        ",SurveyNo = '" + getSurveyNo() + '\'' +
                        "}";
    }

    public String getCompID() { return compID; }

    public void setCompID(String compID) { this.compID = compID; }

    public String getUnitID() { return unitID; }

    public void setUnitID(String unitID) { this.unitID = unitID; }

    public String getSurveyYear() { return surveyYear; }

    public void setSurveyYear(String surveyYear) { this.surveyYear = surveyYear; }

    public String getSurveyNo() { return surveyNo; }

    public void setSurveyNo(String surveyNo) { this.surveyNo = surveyNo; }
}
