package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetEmpPosition implements Serializable {

	@SerializedName("EmpNo")
	private String EmpNo;

	public void setEmpNo(String empNo){
		this.EmpNo = empNo;
	}

	public String getEmpNo(){
		return EmpNo;
	}
}