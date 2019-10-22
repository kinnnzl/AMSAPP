package com.example.amsapp.Api;

import com.example.amsapp.Models.CenterCallApiModel;
import com.example.amsapp.Models.CompanyModel;
import com.example.amsapp.Models.EmpPositionModel;
import com.example.amsapp.Models.GetCompany;
import com.example.amsapp.Models.GetEmpPosition;
import com.example.amsapp.Models.GetLocation;
import com.example.amsapp.Models.GetSpinnerAssetStatus;
import com.example.amsapp.Models.GetSurveyAssetSave;
import com.example.amsapp.Models.GetSurveyDetails;
import com.example.amsapp.Models.GetUnit;
import com.example.amsapp.Models.ResponseQRAssetInfo;
import com.example.amsapp.Models.SurveyAssetSave;
import com.example.amsapp.Models.UnitModel;
import com.example.amsapp.Models.VerifyUserLoginModel;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.Call;

public interface Api {

    @FormUrlEncoded
    @POST("VerifyUserLogin")
    Call<VerifyUserLoginModel> VerifyUserLogin(
            @Field("DevMode") boolean DevMode,
            @Field("AppCode") String AppCode,
            @Field("UserID") String UserID,
            @Field("UserPassword") String UserPassword,
            @Field("DBServerLogin") String DBServerLogin
    );

    @POST("callapi")
    Call<ResponseQRAssetInfo> QRAssetInfo(
            @Body CenterCallApiModel M
    );

    @POST("callapi")
    Call<List<GetLocation>> GetLocation(
            @Body CenterCallApiModel M
    );

    @POST("callapi")
    Call<List<GetCompany>> GetCompanyData(
            @Body CenterCallApiModel M
    );

    @POST("callapi")
    Call<List<GetUnit>> GetUnitData(
            @Body CenterCallApiModel M
    );

    @POST("callapi")
    Call<GetSurveyAssetSave> SaveSurveyDetails(
            @Body CenterCallApiModel M
    );

    @POST("callapi")
    Call<GetSurveyDetails> GetSurveyDetails(
            @Body CenterCallApiModel M
    );

    @POST("callapi")
    Call<List<GetSpinnerAssetStatus>> GetSpinnerAssetStatus(
            @Body CenterCallApiModel M
    );


    @POST("GetEmpPosition")
    Call<List<EmpPositionModel>> GetEmpPosition(
            @Body GetEmpPosition EmpNo
    );


    @POST("GetCompanyPermission_2")
    Call<List<CompanyModel>> GetCompanyPermission_2(
            @Body GetCompany GetComp
    );

    @POST("GetListAllUnitByPermit")
    Call<UnitModel> GetListAllUnitByPermit(
            @Body GetCompany GetUnit
    );
}
