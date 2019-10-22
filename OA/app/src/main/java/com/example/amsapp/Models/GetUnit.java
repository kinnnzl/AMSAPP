package com.example.amsapp.Models;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class GetUnit implements Serializable {

    @SerializedName("UnitID")
    private String unitID;

    @SerializedName("UnitCode")
    private String unitCode;

    @SerializedName("SurveyYear")
    private String surveyYear;

    @SerializedName("SurveyNo")
    private String surveyNo;

    public String getUnitID() { return unitID; }

    public void setUnitID(String unitID) { this.unitID = unitID; }

    public String getUnitCode() { return unitCode; }

    public void setUnitCode(String unitCode) { this.unitCode = unitCode; }

    public String getSurveyYear() { return surveyYear; }

    public void setSurveyYear(String surveyYear) { this.surveyYear = surveyYear; }

    public String getSurveyNo() { return surveyNo; }

    public void setSurveyNo(String surveyNo) { this.surveyNo = surveyNo; }
}
