package com.example.amsapp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientOEMS {
    private static final String URLLogin = "http://10.254.15.14/CDG/MasterAPIs_For_11/OEMSApi/api/OEMS/";

    private static RetrofitClientOEMS mInstance;
    private Retrofit retrofit;

    private RetrofitClientOEMS(){
        retrofit = new Retrofit.Builder()
                .baseUrl(URLLogin)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClientOEMS getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClientOEMS();
        }

        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
