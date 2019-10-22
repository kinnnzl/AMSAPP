package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class EmpPositionModel implements Serializable {

	@SerializedName("StartDate")
	private String startDate;

	@SerializedName("UpdBy")
	private String updBy;

	@SerializedName("UpdDate")
	private String updDate;

	@SerializedName("PositionID")
	private String positionID;

	@SerializedName("EmpNo")
	private String empNo;

	@SerializedName("Priority")
	private int priority;

	@SerializedName("EndDate")
	private String endDate;

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	public void setUpdBy(String updBy){
		this.updBy = updBy;
	}

	public String getUpdBy(){
		return updBy;
	}

	public void setUpdDate(String updDate){
		this.updDate = updDate;
	}

	public String getUpdDate(){
		return updDate;
	}

	public void setPositionID(String positionID){
		this.positionID = positionID;
	}

	public String getPositionID(){
		return positionID;
	}

	public void setEmpNo(String empNo){
		this.empNo = empNo;
	}

	public String getEmpNo(){
		return empNo;
	}

	public void setPriority(int priority){
		this.priority = priority;
	}

	public int getPriority(){
		return priority;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}
}