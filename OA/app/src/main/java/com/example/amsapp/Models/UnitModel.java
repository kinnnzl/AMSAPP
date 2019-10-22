package com.example.amsapp.Models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UnitModel implements Serializable {

	@SerializedName("Status")
	private boolean status;

	@SerializedName("ErrMsg")
	private String errMsg;

	@SerializedName("Data")
	private List<DataItem> data;

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setErrMsg(String errMsg){
		this.errMsg = errMsg;
	}

	public String getErrMsg(){
		return errMsg;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}
}