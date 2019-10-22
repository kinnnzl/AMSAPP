package com.example.amsapp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientQRAssetInfo {
    private static final String URLQRAssetInfo = "http://10.254.15.14/CDG/AMS_Mobile_internet/Center/";

    private static RetrofitClientQRAssetInfo mInstance;
    private Retrofit retrofit;

    private RetrofitClientQRAssetInfo(){
        retrofit = new Retrofit.Builder()
                .baseUrl(URLQRAssetInfo)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClientQRAssetInfo getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClientQRAssetInfo();
        }

        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
