package com.example.amsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.amsapp.Models.GetLocation;
import com.google.zxing.Result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

import static android.Manifest.permission.CAMERA;

public class QRSurveyActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView mScannerView;
    public String SurveyID, CompID, SurveyUnitId, SurveyYear, AssetID, AssetName, SerialNo, LCompID,
            LUnitID, OfficeID, ZoneID, FloorID, message, UserID;
    public int Province, SurveyNo;
    public String strQR1, strQR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrsurvey);
        setTitle("Scan QR Code Survey");

        // Set button back before activity
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get data from SelectBeforeSurveyActivity
        Bundle bundle = getIntent().getExtras();
        SurveyID = bundle.getString("SurveyID");
        CompID = bundle.getString("CompID");
        SurveyUnitId = bundle.getString("SurveyUnitID");
        SurveyYear = bundle.getString("SurveyYear");
        SurveyNo = bundle.getInt("SurveyNo");
        LCompID = bundle.getString("LCompID");
        LUnitID = bundle.getString("LUnitID");
        Province = bundle.getInt("Province");
        OfficeID = bundle.getString("OfficeID");
        ZoneID = bundle.getString("ZoneID");
        FloorID = bundle.getString("FloorID");
        UserID = bundle.getString("UserID");

        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M) {
            if (checkPermission()) { } else {
                requestPermission();
            }
        }
    }

    // Button back before activity
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private boolean checkPermission() {
        return ( ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA ) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{CAMERA}, REQUEST_CAMERA);
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CAMERA:
                if (grantResults.length > 0) {

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted){
                        Toast.makeText(getApplicationContext(), "Permission Granted, Now you can access camera", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Permission Denied, You cannot access and camera", Toast.LENGTH_LONG).show();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CAMERA)) {
                                showMessageOKCancel("You need to allow access to both the permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CAMERA},
                                                            REQUEST_CAMERA);
                                                }
                                            }
                                        });
                                return;
                            }
                        }
                    }
                }
                break;
        }
    }

    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    @Override
    public void onResume() {
        super.onResume();

        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= android.os.Build.VERSION_CODES.M) {
            if (checkPermission()) {
                if(mScannerView == null) {
                    mScannerView = new ZXingScannerView(this);
                    setContentView(mScannerView);
                }
                mScannerView.setResultHandler(this);
                mScannerView.startCamera();
            } else {
                requestPermission();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(final Result rawResult) {
        if (String.valueOf(rawResult).length() >= 20) {
            StringTokenizer tokenList1 = new StringTokenizer(String.valueOf(rawResult), "\n");
            for (int i = 1; tokenList1.hasMoreTokens(); i++) {
                switch (i) {
                    case 1:
                        strQR1 = tokenList1.nextToken();
                        break;
                }
                break;
            }
            StringTokenizer tokenList2 = new StringTokenizer(strQR1+":", ":");
            for (int j = 1; tokenList2.hasMoreTokens(); j++) {
                strQR2 = tokenList2.nextToken();
                strQR2 = tokenList2.nextToken();
            }
            Toast.makeText(this, strQR2, Toast.LENGTH_LONG).show();
            setAssetIDtoStartActivity(strQR2);
        }
        else {
            Toast.makeText(this, rawResult.getText(), Toast.LENGTH_LONG).show();
            setAssetIDtoStartActivity(rawResult.toString());
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(QRSurveyActivity.this);
            }
        }, 3000);

    }

    private void setAssetIDtoStartActivity(String resultAssetID) {
        Intent intent = new Intent(QRSurveyActivity.this, showDetailSurveyActivity.class);
        intent.putExtra("SurveyID", SurveyID);
        intent.putExtra("CompID", CompID);
        intent.putExtra("SurveyUnitID", SurveyUnitId);
        intent.putExtra("SurveyYear", SurveyYear);
        intent.putExtra("SurveyNo", SurveyNo);
        intent.putExtra("AssetID", resultAssetID);
        intent.putExtra("LCompID", LCompID);
        intent.putExtra("LUnitID", LUnitID);
        intent.putExtra("Province", Province);
        intent.putExtra("OfficeID", OfficeID);
        intent.putExtra("ZoneID", ZoneID);
        intent.putExtra("FloorID", FloorID);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }
}
