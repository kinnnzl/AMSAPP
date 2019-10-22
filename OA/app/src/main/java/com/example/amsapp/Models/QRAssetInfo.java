package com.example.amsapp.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class QRAssetInfo implements Serializable {

	@SerializedName("AssetID")
	private String assetID;

	public void setAssetID(String assetID){
		this.assetID = assetID;
	}

	public String getAssetID(){
		return assetID;
	}

	@Override
 	public String toString(){
		return 
			"QRAssetInfo{" + 
			"assetID = '" + assetID + '\'' + 
			"}";
		}
}