package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetSpinnerAssetStatus implements Serializable {

    @SerializedName("ID")
    private String iD;

    @SerializedName("Value")
    private String value;

    @SerializedName("Text")
    private String text;

    @SerializedName("Seq")
    private int seq;

    @SerializedName("Selected")
    private boolean selected;

    @SerializedName("DataOption")
    private String dataOption;

    public String getiD() { return iD; }

    public void setiD(String iD) { this.iD = iD; }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public int getSeq() { return seq; }

    public void setSeq(int seq) { this.seq = seq; }

    public boolean isSelected() { return selected; }

    public void setSelected(boolean selected) { this.selected = selected; }

    public String getDataOption() { return dataOption; }

    public void setDataOption(String dataOption) { this.dataOption = dataOption; }
}
