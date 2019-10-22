package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CompanyModel implements Serializable {

	@SerializedName("CompEName")
	private String compEName;

	@SerializedName("CompTName")
	private String compTName;

	@SerializedName("Value")
	private String value;

	@SerializedName("Text")
	private String text;

	@SerializedName("ID")
	private int iD;

	@SerializedName("Selected")
	private boolean selected;

	@SerializedName("DataOption")
	private String dataOption;

	@SerializedName("Seq")
	private int seq;

	@SerializedName("GroupID")
	private String groupID;

	public void setCompEName(String compEName){
		this.compEName = compEName;
	}

	public String getCompEName(){
		return compEName;
	}

	public void setCompTName(String compTName){
		this.compTName = compTName;
	}

	public String getCompTName(){
		return compTName;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setID(int iD){
		this.iD = iD;
	}

	public int getID(){
		return iD;
	}

	public void setSelected(boolean selected){
		this.selected = selected;
	}

	public boolean isSelected(){
		return selected;
	}

	public void setDataOption(String dataOption){
		this.dataOption = dataOption;
	}

	public String getDataOption(){
		return dataOption;
	}

	public void setSeq(int seq){
		this.seq = seq;
	}

	public int getSeq(){
		return seq;
	}

	public void setGroupID(String groupID){
		this.groupID = groupID;
	}

	public String getGroupID(){
		return groupID;
	}
}