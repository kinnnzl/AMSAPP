package com.example.amsapp;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.amsapp.Api.RetrofitClientQRAssetInfo;
import com.example.amsapp.Models.CenterCallApiModel;
import com.example.amsapp.Models.GetCompany;
import com.example.amsapp.Models.GetEmpPosition;
import com.example.amsapp.Models.GetLocation;
import com.example.amsapp.Models.GetUnit;
import com.example.amsapp.Models.SearchDocAssetDetail;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SelectBeforeSurveyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String[] Year = new String[]{ String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) };
    private TextView plan1, increasePeriod1, surveySuccess1, waitingSurvey1, sumExplore1, sumNotExplore1, departCorrect1,
            departNotCorrect1, placeCorrect1, placeNotCorrect1;
    private List<String> listPosition;
    private GetEmpPosition getEmpPosition;
    private GetCompany getCompany;
    private List<String> listComp, listUnit, listLocation;
    private List<GetCompany> tempListComp;
    private List<GetUnit> tempListUnit;
    private List<GetLocation> tempListLocation;
    private Button btnSurvey, btnBack;
    private SearchDocAssetDetail QAI;
    private CenterCallApiModel CCM;
    private ProgressBar spinner;
    private ConstraintLayout layout;
    public int spinComp, spinUnit, spinLocation;
    public String spinYear, UserID;
    public Spinner spinnerYear, spinnerCom, spinnerDepartment, spinnerLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_before_survey);

        // Get UserID
        Bundle bundle = getIntent().getExtras();
        UserID = bundle.getString("UserID");

        // Set button back before activity
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set Spinner loading data
        spinner = (ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.GONE);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.GONE);
            }
        });

        // Set ConstraintLayout on click screen cancel spinner loading data
        layout = (ConstraintLayout) findViewById(R.id.select_before_survey);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setVisibility(View.GONE);
            }
        });

        // Set button survey
        btnSurvey = findViewById(R.id.btnSearch);
        btnSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get position on selected dropdown
                spinYear = spinnerYear.getSelectedItem().toString();
                spinComp = spinnerCom.getSelectedItemPosition();
                spinUnit = spinnerDepartment.getSelectedItemPosition();
                spinLocation = spinnerLocation.getSelectedItemPosition();

                Intent intent = new Intent(SelectBeforeSurveyActivity.this, QRSurveyActivity.class);
                intent.putExtra("SurveyID", tempListLocation.get(spinLocation).getSurveyID());
                intent.putExtra("CompID", tempListComp.get(spinComp).getCompID());
                intent.putExtra("SurveyUnitID", tempListLocation.get(spinLocation).getSurveyUnitID());
                intent.putExtra("SurveyYear", "2019");
                intent.putExtra("SurveyNo", tempListLocation.get(spinLocation).getSurveyNo());
                intent.putExtra("LCompID", tempListLocation.get(spinLocation).getLoCompID());
                intent.putExtra("LUnitID", tempListLocation.get(spinLocation).getLocationUnitID());
                intent.putExtra("Province", tempListLocation.get(spinLocation).getProvinceID());
                intent.putExtra("OfficeID", tempListLocation.get(spinLocation).getOfficeID());
                intent.putExtra("ZoneID", tempListLocation.get(spinLocation).getZoneID());
                intent.putExtra("FloorID", tempListLocation.get(spinLocation).getFloorID());
                intent.putExtra("UserID", UserID);
                startActivity(intent);
            }
        });

        // Set button back
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SetDropDownYear();
    }

    private void setDataOnTable() {
        plan1 = findViewById(R.id.plan1);
        increasePeriod1 = findViewById(R.id.increasePeriod1);
        surveySuccess1 = findViewById(R.id.surveySuccess1);
        waitingSurvey1 = findViewById(R.id.waitingSurvey1);
        sumExplore1 = findViewById(R.id.sumExplore1);
        sumNotExplore1 = findViewById(R.id.sumNotExplore1);
        departCorrect1 = findViewById(R.id.departCorrect1);
        departNotCorrect1 = findViewById(R.id.departNotCorrect1);
        placeCorrect1 = findViewById(R.id.placeCorrect1);
        placeNotCorrect1 = findViewById(R.id.placeNotCorrect1);

        plan1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetInPlan_Y());
        increasePeriod1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetInPlan_N());
        surveySuccess1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetSurvey_Y());
        waitingSurvey1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetSurvey_N());
        sumExplore1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetFound_Y());
        sumNotExplore1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetFound_N());
        departCorrect1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetUnitMatch_Y());
        departNotCorrect1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetUnitMatch_N());
        placeCorrect1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetLocationMatch_Y());
        placeNotCorrect1.setText(tempListLocation.get(spinnerLocation.getSelectedItemPosition()).getAssetLocationMatch_N());
    }

    // Button back before activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void GetCompanyData(String year) {
        String server = "http://10.254.15.14/CDG/AMS_Mobile/";
        String target = "api/Survey/Get_SearchSurveyPlanCompany";
        CCM = new CenterCallApiModel();
        CCM.setTarget(server + target);
        QAI = new SearchDocAssetDetail();
        QAI.setSurveyYear(year);
        CCM.setJson(new Gson().toJson(QAI));
        Call<List<GetCompany>> callCompany = RetrofitClientQRAssetInfo
                .getInstance()
                .getApi()
                .GetCompanyData(CCM);

        ActionCallApiCompany(callCompany);
    }

    private void ActionCallApiCompany(Call<List<GetCompany>> callCompany) {
        callCompany.enqueue(new Callback<List<GetCompany>>() {
            @Override
            public void onResponse(Call<List<GetCompany>> call, Response<List<GetCompany>> response) {
                listComp = new ArrayList<>();
                for (int i = 0; i < response.body().size(); i++  ){
                    listComp.add(response.body().get(i).getCompCode());
                }

                tempListComp = new ArrayList<>();
                tempListComp = response.body();
                SetDropDownCompany(listComp);
            }

            @Override
            public void onFailure(Call<List<GetCompany>> call, Throwable t) {

            }
        });
    }

    private void GetUnitData(String year, String compId) {
        Log.d("Data", compId);
        String server = "http://10.254.15.14/CDG/AMS_Mobile/";
        String target = "api/Survey/Get_SearchSurveyPlanUnit";
        CCM = new CenterCallApiModel();
        CCM.setTarget(server + target);
        QAI = new SearchDocAssetDetail();
        QAI.setCompID(compId);
        QAI.setSurveyYear(year);
        CCM.setJson(new Gson().toJson(QAI));
        Call<List<GetUnit>> callUnit = RetrofitClientQRAssetInfo
                .getInstance()
                .getApi()
                .GetUnitData(CCM);

        ActionCallApiUnit(callUnit);
    }

    private void ActionCallApiUnit(Call<List<GetUnit>> callCompany) {
        if (listUnit == null) spinner.setVisibility(View.VISIBLE);
        callCompany.enqueue(new Callback<List<GetUnit>>() {
            @Override
            public void onResponse(Call<List<GetUnit>> call, Response<List<GetUnit>> response) {
                listComp = new ArrayList<>();
                for (int i = 0; i < response.body().size(); i++  ){
                    listComp.add(response.body().get(i).getUnitCode() + " - " + "ครั้งที่ " + response.body().get(i).getSurveyNo());
                }
                tempListUnit = new ArrayList<>();
                tempListUnit = response.body();
                if (listUnit != null) spinner.setVisibility(View.GONE);
                SetDropDownUnit(listComp);
            }

            @Override
            public void onFailure(Call<List<GetUnit>> call, Throwable t) {

            }
        });
    }

    private void GetLocation(String year, String compID, String unitID, String surveyNo) {
        String server = "http://10.254.15.14/CDG/AMS_Mobile/";
        String target = "api/Survey/Get_SearchSurveyPlanLocation";
        CCM = new CenterCallApiModel();
        CCM.setTarget(server + target);
        QAI = new SearchDocAssetDetail();
        QAI.setCompID(compID);
        QAI.setUnitID(unitID);
        QAI.setSurveyYear(year);
        QAI.setSurveyNo(surveyNo);
        CCM.setJson(new Gson().toJson(QAI));
        Call<List<GetLocation>> callLocation = RetrofitClientQRAssetInfo
                .getInstance()
                .getApi()
                .GetLocation(CCM);

        ActionCallApiLocation(callLocation);
    }

    private void ActionCallApiLocation(Call<List<GetLocation>> callLocation) {
        if (listLocation == null) spinner.setVisibility(View.VISIBLE);
        callLocation.enqueue(new Callback<List<GetLocation>>() {
            @Override
            public void onResponse(Call<List<GetLocation>> call, Response<List<GetLocation>> response) {
                listLocation = new ArrayList<>();
                for (int i = 0; i < response.body().size(); i++  ){
                    listLocation.add(response.body().get(i).getLocationName());
                }

                tempListLocation = new ArrayList<>();
                tempListLocation = response.body();
                if (listLocation != null) spinner.setVisibility(View.GONE);
                SetDropDownLocation(listLocation);
            }

            @Override
            public void onFailure(Call<List<GetLocation>> call, Throwable t) {

            }
        });
    }

    public void SetDropDownYear() {
        spinnerYear = (Spinner) findViewById(R.id.spinnerYear);
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Year);
        // Specify layout to be used when list of choices appears
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinnerYear.setAdapter(adapterYear);
        spinnerYear.setOnItemSelectedListener(this);
    }

    public void SetDropDownCompany(List<String> listComp) {

        spinnerCom = (Spinner) findViewById(R.id.spinnerCompany);
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> adapterComp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listComp);
        // Specify layout to be used when list of choices appears
        adapterComp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinnerCom.setAdapter(adapterComp);
        spinnerCom.setOnItemSelectedListener(this);
    }

    public void SetDropDownUnit(List<String> listUnit) {
        spinnerDepartment = (Spinner) findViewById(R.id.spinnerDepartment);
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> adapterComp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listUnit);
        // Specify layout to be used when list of choices appears
        adapterComp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinnerDepartment.setAdapter(adapterComp);
        spinnerDepartment.setOnItemSelectedListener(this);
    }

    public void SetDropDownLocation(List<String> listLocation) {
        spinnerLocation = (Spinner) findViewById(R.id.spinnerPlace);
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<String> adapterComp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, listLocation);
        // Specify layout to be used when list of choices appears
        adapterComp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinnerLocation.setAdapter(adapterComp);
        spinnerLocation.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spinnerYear:
                GetCompanyData(spinnerYear.getSelectedItem().toString());
                break;
            case R.id.spinnerCompany:
                listLocation = null;
                listUnit = null;
                spinner.setVisibility(View.GONE);
                GetUnitData(spinnerYear.getSelectedItem().toString(),
                        tempListComp.get(spinnerCom.getSelectedItemPosition()).getCompID());
                break;
            case R.id.spinnerDepartment:
                listLocation = null;
                spinner.setVisibility(View.GONE);
                GetLocation(spinnerYear.getSelectedItem().toString(),
                        tempListComp.get(spinnerCom.getSelectedItemPosition()).getCompID(),
                        tempListUnit.get(spinnerDepartment.getSelectedItemPosition()).getUnitID(),
                        tempListUnit.get(spinnerDepartment.getSelectedItemPosition()).getSurveyNo());
                break;
            case R.id.spinnerPlace:
                setDataOnTable();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }
}
