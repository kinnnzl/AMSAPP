package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CenterCallApiModel implements Serializable {

	@SerializedName("json")
	private String json;

	@SerializedName("target")
	private String target;

	public void setJson(String json){
		this.json = json;
	}

	public String getJson(){
		return json;
	}

	public void setTarget(String target){
		this.target = target;
	}

	public String getTarget(){
		return target;
	}
}