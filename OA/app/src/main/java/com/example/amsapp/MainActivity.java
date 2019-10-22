package com.example.amsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.amsapp.Api.RetrofitClient;
import com.example.amsapp.Models.VerifyUserLoginModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private static String UserID;

    public static String getUserID() {
        return UserID;
    }

    public static String EmpLogIn;

    private TextView loginStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginStatus = findViewById(R.id.loginStatus);


        final EditText txtUserID = findViewById(R.id.txtUserID);
        final EditText txtPassword = findViewById(R.id.txtPassword);
        btn = findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for login param
                boolean DevMode = false;
                String AppCde = "PETTYCASH3";
                UserID = txtUserID.getText().toString().trim();
//                String Password = txtPassword.getText().toString().trim();

//                UserID = "005497";
                String Password = "1";
                String DBServer = "10.254.15.11";


                if (UserID.isEmpty()){
                    txtUserID.setError("กรุณาใส่รหัสพนักงาน");
                    txtUserID.requestFocus();
                    return;
                }

                if(Password.isEmpty()){
                    txtPassword.setError("กรุณาใส่รหัสผ่าน");
                    txtPassword.requestFocus();
                    return;
                }

                Call<VerifyUserLoginModel> call = RetrofitClient
                        .getInstance()
                        .getApi()
                        .VerifyUserLogin(DevMode, AppCde, UserID, Password, DBServer);


                call.enqueue(new Callback<VerifyUserLoginModel>() {
                    @Override
                    public void onResponse(Call<VerifyUserLoginModel> call, Response<VerifyUserLoginModel> response) {

                        String s = response.body().getLogin();

                        if (!s.isEmpty() && s.equalsIgnoreCase("PASS"))
                        {
//                            Toast.makeText(MainActivity.this, "Log-in สำเร็จ", Toast.LENGTH_LONG).show();
                            OpenQRActivity();

                        }else {
                            Toast.makeText(MainActivity.this, "Log-in ไม่สำเร็จกรุณาตรวจสอบ User และ Password อีกครั้ง", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<VerifyUserLoginModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }

    public void OpenQRActivity()
    {
        loginStatus.setText("Sign In Successfully");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, CenterActivity.class);
                intent.putExtra("UserID", UserID);
                startActivity(intent);
                finish();
            }
        }, 1000);
        //finish();
    }

    // Set font cdg
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));
    }
}
