package com.freelancing.ahmed.fondooy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.md5simply.MD5;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.ExceptionHandler;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;
import com.freelancing.ahmed.fondooy.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText etEmail, etPassword;
    private TextView register, passreset;
    final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        login = (Button) findViewById(R.id.loginbtn);
        etEmail = (EditText) findViewById(R.id.etemail);
        etPassword = (EditText) findViewById(R.id.etpass);
        register = (TextView) findViewById(R.id.registerbtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(myIntent);
                finish();
            }
        });
        login.setOnClickListener(this);

        }
    private boolean emptyValidate(EditText etEmail, EditText etPassword){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        return (email.isEmpty() && password.isEmpty());
    }
    String password = "";
    @Override
    public void onClick(View v) {
        final String email = etEmail.getText().toString();
        password =  MD5.encrypt(etPassword.getText().toString());
        //password =etPassword.getText().toString();
        HashMap<String, String> loginData = new HashMap<>();
        loginData.put("email", email);
        loginData.put("password", password);
        PostResponseAsyncTask loginTask = new PostResponseAsyncTask(this,
                loginData, new AsyncResponse() {
            @Override
            public void processFinish(String s) {
                Log.d(TAG, s);
                if(s.contains("LoginSuccess")){
                    SharedPreferences pref = getSharedPreferences("loginData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("email", email);
                    editor.putString("password", password);

                    editor.commit();
                    Intent in = new Intent(getApplicationContext(), Main2Activity.class);
                    in.putExtra("emailing", email);
                    startActivity(in);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Something went wrong. Cannot login.", Toast.LENGTH_LONG).show();
                }
            }
        });
        loginTask.setExceptionHandler(new ExceptionHandler() {
            @Override
            public void handleException(Exception e) {
                if(e != null && e.getMessage() != null){
                    Log.d(TAG, e.getMessage());
                }
            }
        });
        loginTask.execute("http://ahmedayman1708.000webhostapp.com/fondoo2/login.php");
    }
    }
