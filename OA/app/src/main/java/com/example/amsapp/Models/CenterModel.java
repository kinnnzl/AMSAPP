package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CenterModel implements Serializable {

	@SerializedName("ID")
	private int id;

	@SerializedName("Desc")
	private String desc;

	@SerializedName("Img")
	private int img;

	@SerializedName("Title")
	private String title;

	public CenterModel(int id, String title, String desc, int image) {
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.img = image;
	}

	public int getId() {
		return id;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getDesc(){
		return desc;
	}

	public void setImg(int img){
		this.img = img;
	}

	public int getImg(){
		return img;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"CenterModel{" + 
			"desc = '" + desc + '\'' + 
			",img = '" + img + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}