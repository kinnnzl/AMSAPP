package com.example.amsapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseQRAssetInfo implements Serializable, Parcelable {

	@SerializedName("Status")
	private boolean status;

	@SerializedName("ErrMsg")
	private String errMsg;

	@SerializedName("Data")
	private Data data;

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

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeByte(this.status ? (byte) 1 : (byte) 0);
		dest.writeString(this.errMsg);
		dest.writeSerializable(this.data);
	}

	protected ResponseQRAssetInfo(Parcel in) {
		this.status = in.readByte() != 0;
		this.errMsg = in.readString();
		this.data = (Data) in.readSerializable();
	}

	public static final Parcelable.Creator<ResponseQRAssetInfo> CREATOR = new Parcelable.Creator<ResponseQRAssetInfo>() {
		@Override
		public ResponseQRAssetInfo createFromParcel(Parcel source) {
			return new ResponseQRAssetInfo(source);
		}

		@Override
		public ResponseQRAssetInfo[] newArray(int size) {
			return new ResponseQRAssetInfo[size];
		}
	};
}