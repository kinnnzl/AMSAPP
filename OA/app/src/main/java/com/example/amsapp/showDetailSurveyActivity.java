package com.example.amsapp;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.alespero.expandablecardview.ExpandableCardView;
import com.example.amsapp.Api.RetrofitClientQRAssetInfo;
import com.example.amsapp.Models.CenterCallApiModel;
import com.example.amsapp.Models.GetSpinnerAssetStatus;
import com.example.amsapp.Models.GetSurveyAssetSave;
import com.example.amsapp.Models.GetSurveyDetails;
import com.example.amsapp.Models.SpinnerAssetStatus;
import com.example.amsapp.Models.SurveyAssetDetails;
import com.example.amsapp.Models.SurveyAssetSave;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class showDetailSurveyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String SurveyID, CompID, SurveyUnitId, SurveyYear, AssetID, LCompID,
            LUnitID, OfficeID, ZoneID, FloorID, Updby, valueAssetStatus;
    public int Province, SurveyNo;
    public GetSurveyDetails tempSurvey;
    private List<String> listSpinnerAsset, listValueSpinnerAsset;
    private TextView assetCode, assetName, dateReceiveAsset, company, departmentHolding, employeeHolding,
            positionCompany, positionDepartment, positionProvince, positionPlace, positionZone,
            surveyStatus, sumDepartmentHolding, assetLocation;
    private EditText note, serialNo;
    private Button btnSave, btnBack;
    private int roundExpandableCardView = 1;
    private int roundExpandableSerialNo = 1;
    private SurveyAssetDetails QAI;
    private SurveyAssetSave QAA;
    private SpinnerAssetStatus SAS;
    private CenterCallApiModel CCM;
    private Spinner spinAssetStatus;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail_survey);

        // Set button back before activity
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set button back
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Set button save
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String server = "http://10.254.15.14/CDG/AMS_Mobile/";
                String target = "api/Survey/InsertSurveyAssetResultNew";
                CCM = new CenterCallApiModel();
                CCM.setTarget(server + target);

                QAA = new SurveyAssetSave();
                setDataToSaveSurvey(QAA);


                CCM.setJson(new Gson().toJson(QAA));
                Call<GetSurveyAssetSave> callSurveySave = RetrofitClientQRAssetInfo
                        .getInstance()
                        .getApi()
                        .SaveSurveyDetails(CCM);

                ActionCallApiSave(callSurveySave);
            }
        });

        // Get data from SelectBeforeSurveyActivity
        Bundle bundle = getIntent().getExtras();
        SurveyID = bundle.getString("SurveyID");
        CompID = bundle.getString("CompID");
        SurveyUnitId = bundle.getString("SurveyUnitID");
        SurveyYear = bundle.getString("SurveyYear");
        SurveyNo = bundle.getInt("SurveyNo");
        AssetID = bundle.getString("AssetID");
        LCompID = bundle.getString("LCompID");
        LUnitID = bundle.getString("LUnitID");
        Province = bundle.getInt("Province");
        OfficeID = bundle.getString("OfficeID");
        ZoneID = bundle.getString("ZoneID");
        FloorID = bundle.getString("FloorID");
        Updby = bundle.getString("UserID");

        // Call api data asset survey
        getSurveyDetails();
        setDelayActivity();
    }

    private void setDelayActivity() {
        // Set Spinner loading data
        spinner = (ProgressBar)findViewById(R.id.progressBarSurvey);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                spinner.setVisibility(View.GONE);
            }
        }, 500);
    }

    private void setDataToSaveSurvey(SurveyAssetSave qaa) {
        qaa.setSurveyID(SurveyID);
        qaa.setCompID(CompID);
        qaa.setUnitID(SurveyUnitId);
        qaa.setSurveyYear(SurveyYear);
        qaa.setSurveyNo(SurveyNo);
        qaa.setAssetID(tempSurvey.getAssetID());
        qaa.setAssetStatus(valueAssetStatus);
        qaa.setUnitIDOwner(tempSurvey.getUnitIDOwner());
        qaa.setEmpNoOwner(tempSurvey.getEmpNoOwner());
        qaa.setlCompID(tempSurvey.getlCompID());
        qaa.setlUnitID(tempSurvey.getlUnitID());
        qaa.setProvinceCode(tempSurvey.getProvinceCode());
        qaa.setOfficeID(tempSurvey.getOfficeId());
        qaa.setZoneID(tempSurvey.getZoneId());
        qaa.setFloor(tempSurvey.getFloor());
        qaa.setResultFound(tempSurvey.getFoundAsset());
        qaa.setResultUnitOwner(tempSurvey.getUnitIDMatch());
        qaa.setResultLocation(tempSurvey.getLocationMatch());
        qaa.setSurveyActionResult("Y");
        qaa.setSurveyRemark(String.valueOf(note.getText()));
        qaa.setSurveyBy(Updby);
    }

    private void ActionCallApiSave(Call<GetSurveyAssetSave> callSurveySave) {
        callSurveySave.enqueue(new Callback<GetSurveyAssetSave>() {

            @Override
            public void onResponse(Call<GetSurveyAssetSave> call, Response<GetSurveyAssetSave> response) {
                showMessageDialog(response.body().getMessage(), 2);
            }

            @Override
            public void onFailure(Call<GetSurveyAssetSave> call, Throwable t) {

            }
        });
    }

    private void showMessageDialog(String message, final int state) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ข้อความแจ้งเตือน");
        builder.setMessage(message);

        switch (state) {
            case 1:
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                break;
            case 2:
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                break;
        }
        final AlertDialog alert1 = builder.create();
        alert1.show();
    }

    // Button back before activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void setTextAssetDetails(final GetSurveyDetails tempSurvey) {

        ExpandableCardView cardAssetDetails = findViewById(R.id.assetDetailsSurvey);
        cardAssetDetails.expand();
        cardAssetDetails.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {

                // Check onchange editText
                switch (roundExpandableSerialNo) {
                    case 1:
                        serialNo = v.findViewById(R.id.SerialNo);
                        serialNo.setText(tempSurvey.getSerialNo());
                        roundExpandableSerialNo++;
                        break;
                    case 2:
                        serialNo.setText(serialNo.getText());
                        break;
                }

                assetCode = v.findViewById(R.id.assetCode);
                assetName = v.findViewById(R.id.assetName);
                dateReceiveAsset = v.findViewById(R.id.dateReceiveAsset);

                assetCode.setText(tempSurvey.getAssetID());
                assetName.setText(tempSurvey.getAssetName());
                dateReceiveAsset.setText(tempSurvey.getRcvDate());
            }
        });

        ExpandableCardView cardDepartmentDetails = findViewById(R.id.departmentDetails);
        cardDepartmentDetails.expand();
        cardDepartmentDetails.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                company = v.findViewById(R.id.Company);
                departmentHolding = v.findViewById(R.id.departmentHolding);
                employeeHolding = v.findViewById(R.id.employeeHolding);

                company.setText(tempSurvey.getCompCode());
                departmentHolding.setText(tempSurvey.getUnitCodeOwner());

                if (tempSurvey.getEmpNoOwner() != null && tempSurvey.getEmpNameOwner() != null)
                    employeeHolding.setText(tempSurvey.getEmpNoOwner() + " - " + tempSurvey.getEmpNameOwner());
            }
        });

        ExpandableCardView cardPositionAssetDetails = findViewById(R.id.positionAssetDetails);
        cardPositionAssetDetails.expand();
        cardPositionAssetDetails.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                positionCompany = v.findViewById(R.id.positionCompany);
                positionDepartment = v.findViewById(R.id.positionDepartment);
                positionProvince = v.findViewById(R.id.positionProvince);
                positionPlace = v.findViewById(R.id.positionPlace);
                positionZone = v.findViewById(R.id.positionZone);

                positionCompany.setText(tempSurvey.getCompcde());
                positionDepartment.setText(tempSurvey.getlUnitCode());
                positionProvince.setText(tempSurvey.getProvinceName());
                positionPlace.setText(tempSurvey.getOfficeName() + " - " + tempSurvey.getFloorName());
                positionZone.setText(tempSurvey.getZoneName());
            }
        });

        ExpandableCardView cardSummaryAssetDetails = findViewById(R.id.summaryAssetDetails);
        cardSummaryAssetDetails.expand();
        cardSummaryAssetDetails.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                spinAssetStatus = (Spinner) findViewById(R.id.spinnerStatusAsset);

                // Check onchange editText
                switch (roundExpandableCardView) {
                    case 1:
                        note = v.findViewById(R.id.note);
                        note.setText(tempSurvey.getSurveyRemark());
                        note.requestFocus();
                        roundExpandableCardView++;
                        break;
                    case 2:
                        note.setText(note.getText());
                        break;
                }

                surveyStatus = v.findViewById(R.id.surveyStatus);
                sumDepartmentHolding = v.findViewById(R.id.departmentHolding);
                assetLocation = v.findViewById(R.id.assetLocation);

                surveyStatus.setText(tempSurvey.getFoundAssetDesc());
                sumDepartmentHolding.setText(tempSurvey.getUnitIDMatchDesc());
                assetLocation.setText(tempSurvey.getLocationMatchDesc());
                setColorTextSurveyStatus(surveyStatus, sumDepartmentHolding, assetLocation, spinAssetStatus);
            }
        });

    }

    public void setColorTextSurveyStatus(TextView surveyStatus, TextView sumDepartmentHolding, TextView assetLocation, Spinner spinAssetStatus) {
        // Check สถานะการสำรวจ
        if (tempSurvey.getFoundAssetDesc().equals("สำรวจพบ")) surveyStatus.setTextColor(Color.parseColor("#558B2F"));
        else if (tempSurvey.getFoundAssetDesc().equals("สำรวจไม่พบ")) surveyStatus.setTextColor(Color.RED);

        // Check หน่วยงานผู้ถือครอง
        if (tempSurvey.getUnitIDMatchDesc().equals("ถูกต้อง")) sumDepartmentHolding.setTextColor(Color.parseColor("#558B2F"));
        else if (tempSurvey.getUnitIDMatchDesc().equals("ไม่ถูกต้อง")) sumDepartmentHolding.setTextColor(Color.RED);

        // Check สถานที่ตั้งสินทรัพย์
        if (tempSurvey.getLocationMatchDesc().equals("ถูกต้อง")) assetLocation.setTextColor(Color.parseColor("#558B2F"));
        else if (tempSurvey.getLocationMatchDesc().equals("ไม่ถูกต้อง")) assetLocation.setTextColor(Color.RED);

        getAssetStatus(spinAssetStatus);
    }

    private void getAssetStatus(Spinner spinAssetStatus) {
        String server = "http://10.254.15.14/CDG/AMS_Mobile/";
        String target = "api/Survey/GetMasterDataByType";
        CCM = new CenterCallApiModel();
        CCM.setTarget(server + target);

        SAS = new SpinnerAssetStatus();
        SAS.setType("AssetStatus");

        CCM.setJson(new Gson().toJson(SAS));
        Call<List<GetSpinnerAssetStatus>> callSpinner = RetrofitClientQRAssetInfo
                .getInstance()
                .getApi()
                .GetSpinnerAssetStatus(CCM);

        ActionCallApiSpinner(callSpinner, spinAssetStatus);
    }

    private void ActionCallApiSpinner(Call<List<GetSpinnerAssetStatus>> callSpinner, final Spinner spinAssetStatus) {
        callSpinner.enqueue(new Callback<List<GetSpinnerAssetStatus>>() {
            @Override
            public void onResponse(Call<List<GetSpinnerAssetStatus>> call, Response<List<GetSpinnerAssetStatus>> response) {
                listSpinnerAsset = new ArrayList<>();
                listValueSpinnerAsset = new ArrayList<>();
                for (int i = 0; i < response.body().size(); i++) {
                    listSpinnerAsset.add(response.body().get(i).getText());
                    listValueSpinnerAsset.add(response.body().get(i).getValue());
                }

                SetDropDownSpinnerAssetStatus(listSpinnerAsset, spinAssetStatus);
            }

            @Override
            public void onFailure(Call<List<GetSpinnerAssetStatus>> call, Throwable t) {

            }
        });
    }

    private void SetDropDownSpinnerAssetStatus(List<String> listSpinnerAsset, Spinner spinAssetStatus) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listSpinnerAsset);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinAssetStatus.setAdapter(adapter);
        spinAssetStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                valueAssetStatus = listValueSpinnerAsset.get(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Set Selected dropdown asset status
        for (int i = 0; i < listSpinnerAsset.size(); i++){
            if (listSpinnerAsset.get(i).equals(tempSurvey.getAssetStatusDesc()))
                spinAssetStatus.setSelection(i);
        }
    }

    private void getSurveyDetails() {
        String server = "http://10.254.15.14/CDG/AMS_Mobile/";
        String target = "api/Survey/Get_SearchSurveyData";
        CCM = new CenterCallApiModel();
        CCM.setTarget(server + target);

        QAI = new SurveyAssetDetails();
        setDataToSendTarget(QAI);


        CCM.setJson(new Gson().toJson(QAI));
        Call<GetSurveyDetails> callSurvey = RetrofitClientQRAssetInfo
                .getInstance()
                .getApi()
                .GetSurveyDetails(CCM);

        ActionCallApiCompany(callSurvey);
    }

    private void ActionCallApiCompany(Call<GetSurveyDetails> callSurvey) {
        callSurvey.enqueue(new Callback<GetSurveyDetails>() {
            @Override
            public void onResponse(Call<GetSurveyDetails> call, Response<GetSurveyDetails> response) {
                if (response.body().getMessage() == null) {
                    if (!response.body().getPopup().equals("")) showMessageDialog(response.body().getPopup(), 1);
                    tempSurvey = new GetSurveyDetails();
                    tempSurvey = response.body();
                    // Set data in ExpandableCardView
                    setTextAssetDetails(tempSurvey);
                }
                else if (response == null) showMessageDialog(response.body().getMessage(), 2);
                else {
                    showMessageDialog(response.body().getMessage(), 2);
                }
            }

            @Override
            public void onFailure(Call<GetSurveyDetails> call, Throwable t) {

            }
        });
    }

    private void setDataToSendTarget(SurveyAssetDetails qai) {
        qai.setSurveyID(SurveyID);
        qai.setCompID(CompID);
        qai.setSurveyUnitId(SurveyUnitId);
        qai.setSurveyYear(Integer.parseInt(SurveyYear));
        qai.setSurveyNo(String.valueOf(SurveyNo));
        qai.setAssetID(AssetID);
        qai.setlCompID(LCompID);
        qai.setlUnitID(LUnitID);
        qai.setProvince(Province);
        qai.setOfficeID(OfficeID);
        qai.setZoneID(ZoneID);
        qai.setFloorID(FloorID);
        qai.setUpdby(Updby);
    }

    // Set Font Cdg
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}