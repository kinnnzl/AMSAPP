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

import com.example.amsapp.Api.RetrofitClientQRAssetInfo;
import com.example.amsapp.Models.CenterCallApiModel;
import com.example.amsapp.Models.QRAssetInfo;
import com.example.amsapp.Models.ResponseQRAssetInfo;
import com.google.gson.Gson;
import com.google.zxing.Result;

import java.util.StringTokenizer;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.CAMERA;

public class QRInfoActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView mScannerView;
    private QRAssetInfo QAI;
    public String strQR1, strQR2;
    private CenterCallApiModel CCM;
    private String server = "http://10.254.15.14/CDG/AMS_Mobile/";
    private String target = "api/Survey/Get_AssetInfoByAssetID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrinfo);
        setTitle("Scan QR Code Info");

        // Set button back before activity
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
        }
        else {
            Toast.makeText(this, rawResult.getText(), Toast.LENGTH_LONG).show();
            strQR2 = rawResult.getText();
        }

        CCM = new CenterCallApiModel();
        CCM.setTarget(server + target);

        QAI = new QRAssetInfo();
        QAI.setAssetID(strQR2);

        CCM.setJson(new Gson().toJson(QAI));
        Call<ResponseQRAssetInfo> call = RetrofitClientQRAssetInfo
                .getInstance()
                .getApi()
                .QRAssetInfo(CCM);

        ActionCallApiQRAssetInfo(call);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(QRInfoActivity.this);
            }
        }, 3000);

    }

    public void ActionCallApiQRAssetInfo(Call<ResponseQRAssetInfo> call){
        call.enqueue(new Callback<ResponseQRAssetInfo>() {
            @Override
            public void onResponse(Call<ResponseQRAssetInfo> call, Response<ResponseQRAssetInfo> response) {
                boolean Status = response.body().isStatus();

                if (Status){
                    Log.d("Data", response.body().getData().getAssetName());
                    //Toast.makeText(QRInfoActivity.this, "Success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(QRInfoActivity.this, ShowInfoActivity.class);
                    intent.putExtra("ResultQRAssetInfo", response.body().getData());
                    startActivity(intent);
                }else{
                    Toast.makeText(QRInfoActivity.this, "Error", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<ResponseQRAssetInfo> call, Throwable t) {
                Toast.makeText(QRInfoActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
