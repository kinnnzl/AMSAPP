package com.example.amsapp.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetSurveyAssetSave implements Serializable {

    @SerializedName("Message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(this.message);
//    }
//
//    protected GetSurveyAssetSave(Parcel in) {
//        this.message = in.readString();
//    }
//
//    public static final Parcelable.Creator<GetSurveyAssetSave> CREATOR = new Creator<GetSurveyAssetSave>() {
//        @Override
//        public GetSurveyAssetSave createFromParcel(Parcel source) {
//            return new GetSurveyAssetSave(source);
//        }
//
//        @Override
//        public GetSurveyAssetSave[] newArray(int size) {
//            return new GetSurveyAssetSave[size];
//        }
//    };
}
