package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

public class SpinnerAssetStatus {

    @SerializedName("Type")
    private String type;

    @Override
    public String toString(){
        return
                "SearchDocAssetDetail{" +
                        "SurveyID = '" + getType() + '\'' +
                        "}";
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}
