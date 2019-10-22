package com.example.amsapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.alespero.expandablecardview.ExpandableCardView;
import com.example.amsapp.Models.Data;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ShowInfoActivity extends AppCompatActivity {

    private Data ResultQRAssetInfo;
    private TextView assetCode, assetName, dateReceiveAsset, serialNo, departmentHolding, employeeHolding;
    private TextView positionCompany, positionDepartment, positionProvince, positionPlace, positionZone, positionFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinfo);

        // Set button back before activity
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ResultQRAssetInfo = new Data();
        ResultQRAssetInfo = (Data) getIntent().getSerializableExtra("ResultQRAssetInfo");

        ExpandableCardView cardAssetInfo = findViewById(R.id.assetDetailsInfo);
        cardAssetInfo.expand();
        cardAssetInfo.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                assetCode = v.findViewById(R.id.assetCodeInfo);
                assetName = v.findViewById(R.id.assetNameInfo);
                dateReceiveAsset = v.findViewById(R.id.dateReceiveAssetInfo);
                serialNo = v.findViewById(R.id.serialNoInfo);
                departmentHolding = v.findViewById(R.id.departmentHoldingInfo);
                employeeHolding = v.findViewById(R.id.employeeHoldingInfo);

                assetCode.setText(ResultQRAssetInfo.getTmpAssetID());
                assetName.setText(ResultQRAssetInfo.getAssetName());
                dateReceiveAsset.setText(ResultQRAssetInfo.getRcvDate());
                serialNo.setText(ResultQRAssetInfo.getSerialNo());
                departmentHolding.setText(ResultQRAssetInfo.getUnitOwner());
                employeeHolding.setText(ResultQRAssetInfo.getEmpOwner());
            }
        });

        ExpandableCardView cardPlaceInfo = findViewById(R.id.positionAssetInfo);
        cardPlaceInfo.expand();
        cardPlaceInfo.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
            @Override
            public void onExpandChanged(View v, boolean isExpanded) {
                positionProvince = v.findViewById(R.id.positionProvinceInfo);
                positionPlace = v.findViewById(R.id.positionPlaceInfo);
                positionCompany = v.findViewById(R.id.positionCompanyInfo);
                positionZone = v.findViewById(R.id.positionZoneInfo);
                positionDepartment = v.findViewById(R.id.positionDepartmentInfo);
                positionFloor = v.findViewById(R.id.positionFloorInfo);

                positionProvince.setText(ResultQRAssetInfo.getProvinceName());
                positionPlace.setText(ResultQRAssetInfo.getOfficeName());
                positionCompany.setText(ResultQRAssetInfo.getCompcde());
                positionZone.setText(ResultQRAssetInfo.getZoneName());
                positionDepartment.setText(ResultQRAssetInfo.getUnitCode());
                positionFloor.setText(ResultQRAssetInfo.getFloorName());

            }
        });
    }

    // Button back before activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Set Font Cdg
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }
}
