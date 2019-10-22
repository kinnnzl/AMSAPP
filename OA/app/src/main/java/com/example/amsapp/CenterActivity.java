package com.example.amsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.amsapp.Adapter.CenterAdapter;
import com.example.amsapp.Models.CenterModel;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static java.security.AccessController.getContext;

public class CenterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CenterModel> menuList;
    private Button backSignIn;
    private String UserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);

        // Get UserID
        Bundle bundle = getIntent().getExtras();
        UserID = bundle.getString("UserID");

        backSignIn = findViewById(R.id.btnBackSignIn);
        backSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CenterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        menuList = new ArrayList<>();

        menuList.add(
                new CenterModel(
                        1,
                        "Scan QR Code / Scan Barcode",
                        "เพื่อดูรายละเอียดสินทรัพย์",
                        R.drawable.ic_scan_24dp));

        menuList.add(
                new CenterModel(
                        2,
                        "Scan QR Code / Scan Barcode",
                        "เพื่อสำรวจสินทรัพย์",
                        R.drawable.ic_scan_location_24dp));

        recyclerView = findViewById(R.id.centerRec);
        CenterAdapter adapter = new CenterAdapter(this, menuList, UserID);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    // Set font cdg
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }
}
