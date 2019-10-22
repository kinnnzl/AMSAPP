package com.example.amsapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company implements Parcelable {

	@SerializedName("CompID")
	@Expose
	private String compID;

	@SerializedName("CompCode")
	@Expose
	private String compCode;

	@SerializedName("CompFullName")
	@Expose
	private String compFullName;


	protected Company(Parcel in) {
		this.compID = ((String) in.readValue((String.class.getClassLoader())));
		this.compCode = ((String) in.readValue((String.class.getClassLoader())));
		this.compFullName = ((String) in.readValue((String.class.getClassLoader())));
	}

	public static final Creator<Company> CREATOR = new Creator<Company>() {
		@Override
		public Company createFromParcel(Parcel in) {
			return new Company(in);
		}

		@Override
		public Company[] newArray(int size) {
			return new Company[size];
		}
	};

	public String getCompFullName() { return compFullName; }

	public void setCompFullName(String compFullName) { this.compFullName = compFullName; }

	public String getCompCode() { return compCode; }

	public void setCompCode(String compCode) { this.compCode = compCode; }

	public String getCompID() { return compID; }

	public void setCompID(String compID) { this.compID = compID; }


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(compID);
		dest.writeValue(compCode);
		dest.writeValue(compFullName);
	}
}