package com.example.amsapp.Models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetCompany implements Serializable {

	@SerializedName("CompID")
	private String compID;

	@SerializedName("CompCode")
	private String compCode;

	@SerializedName("CompFullName")
	private String compFullName;

	public String getCompID() { return compID; }

	public void setCompID(String compID) { this.compID = compID; }

	public String getCompCode() { return compCode; }

	public void setCompCode(String compCode) { this.compCode = compCode; }

	public String getCompFullName() { return compFullName; }

	public void setCompFullName(String compFullName) { this.compFullName = compFullName; }
}