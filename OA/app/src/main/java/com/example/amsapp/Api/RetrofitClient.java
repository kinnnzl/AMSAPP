package com.example.amsapp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String URLLogin = "http://10.254.15.14/CDG/MasterAPIs/SecurityApi/api/Security/";

    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(URLLogin)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }

        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
