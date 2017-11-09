package com.freelancing.ahmed.fondooy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.md5simply.MD5;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import fr.ganfra.materialspinner.MaterialSpinner;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    final String TAG = "RegisterActivity";
    EditText etName,etUsername,etEmail, etPassword,etPhone,etConfirmPassword;
    Button btnRegister;
    TextView tvLogin;
    String id2,id3;
    public String id22,id33;
    MaterialSpinner mySpinner2;
   List<String> data2 = new ArrayList<>();
    ArrayAdapter<String> myAdapter2;


    MaterialSpinner mySpinner;
    List<String> data = new ArrayList<>();
    ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = (EditText) findViewById(R.id.name);
        etUsername = (EditText) findViewById(R.id.username);
        etPhone = (EditText) findViewById(R.id.phone);
        etEmail = (EditText)findViewById(R.id.email);
        etPassword = (EditText)findViewById(R.id.password);
        etConfirmPassword = (EditText) findViewById(R.id.confpassword);
        btnRegister = (Button)findViewById(R.id.regbtn);
        tvLogin = (TextView) findViewById(R.id.logbtn);
        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lgnintent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(lgnintent);
            }
        });/*
        String[] data2 = {"Egypt", "America"};
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(
                RegisterActivity.this,
                android.R.layout.simple_dropdown_item_1line, data2);
        MaterialBetterSpinner mySpinner = (MaterialBetterSpinner)
                findViewById(R.id.spinner);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id2 =  parent.getItemAtPosition(position).toString();
                id22= Integer.toString(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        String[] data = {"Company 1", "Company 2"};
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(
                RegisterActivity.this,
                android.R.layout.simple_dropdown_item_1line, data);
        MaterialBetterSpinner mySpinner2 = (MaterialBetterSpinner)
                findViewById(R.id.spinner2);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id3 =  parent.getItemAtPosition(position).toString();
                id33= Integer.toString(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        }); */
        mySpinner=(MaterialSpinner)  findViewById(R.id.spinner);
        data = new ArrayList<>();
        data.add("Egypt");
        data.add("America");

        myAdapter= new ArrayAdapter<String>(
                RegisterActivity.this,
                android.R.layout.simple_spinner_dropdown_item, data);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id2 =  parent.getItemAtPosition(position).toString();
                id22= Integer.toString(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
        mySpinner2=(MaterialSpinner)  findViewById(R.id.spinner2);
        data2 = new ArrayList<>();
        data2.add("Copmany 1");
        data2.add("Company 2");

        myAdapter2= new ArrayAdapter<String>(
                RegisterActivity.this,
                android.R.layout.simple_spinner_dropdown_item, data2);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id3 =  parent.getItemAtPosition(position).toString();
                id33= Integer.toString(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        /*
        Locale[] locale = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();

        String country;
        for( Locale loc : locale ){
            country = loc.getDisplayCountry();
            if( country.length() > 0 && !countries.contains(country) ){
                countries.add( country );
            }
        }
        Collections.sort(countries, String.CASE_INSENSITIVE_ORDER);


        mySpinner=(MaterialSpinner)  findViewById(R.id.spinner);
        ArrayAdapter<String> myAdabter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_list_item_1,
                countries);
        myAdabter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdabter);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                id2 =  parent.getItemAtPosition(position).toString();
                id22= Integer.toString(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

*/

    }

    @Override
    protected void onDestroy() {
        Log.v("MediaVideo", "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if(!emptyValidate(etEmail, etPassword , etConfirmPassword, etName , etUsername , etPhone)){
            if(passwordValidate(etPassword, etConfirmPassword)){
                String email = etEmail.getText().toString();
                String password = MD5.encrypt(etPassword.getText().toString());
               // String password = etPassword.getText().toString();
                String name = etName.getText().toString();
                String username = etUsername.getText().toString();
                String phone = etPhone.getText().toString();
                HashMap<String, String> postData = new HashMap<>();
                postData.put("name",name);
                postData.put("uname",username);
                postData.put("email", email);
                postData.put("phone",phone);
                postData.put("password", password);
                postData.put("nationalID",id22);
                postData.put("companyID",id33);
                SharedPreferences pref = getSharedPreferences("loginData", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("email", email);
                editor.putString("password", password);

                editor.commit();

                PostResponseAsyncTask task1 = new PostResponseAsyncTask(this,
                        postData, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        Log.d(TAG, s);
                        if(s.contains("ErrorInsert")){
                            Toast.makeText(RegisterActivity.this,
                                    "Something went wrong. Data was not inserted.",
                                    Toast.LENGTH_LONG).show();
                        }else {
                            Intent in = new Intent(getApplicationContext(),
                                    Main2Activity.class);
                            startActivity(in);

                        }
                    }
                });
                task1.execute("http://ahmedayman1708.000webhostapp.com/fondoo2/register.php");
            }
            else{  // not equals
                Toast.makeText(getApplicationContext(),
                        "Make sure your password is the same to confirm password",
                        Toast.LENGTH_LONG).show();
            }
        } else{
            Toast.makeText(getApplicationContext(), "Fill out all the fields",
                    Toast.LENGTH_LONG).show();
        }
    }
    private boolean emptyValidate(EditText etEmail,
                                  EditText etPassword,
                                  EditText etConfirmPassword,
                                  EditText etName,
                                  EditText etUsername,
                                  EditText etPhone){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String confirm = etConfirmPassword.getText().toString();
        String name = etName.getText().toString();
        String username = etUsername.getText().toString();
        String phone = etPhone.getText().toString();
        return (email.isEmpty() && password.isEmpty() && confirm.isEmpty() && name.isEmpty() && username.isEmpty() && phone.isEmpty());
    }

    private boolean passwordValidate(EditText etPassword,
                                     EditText etConfirmPassword){
        String password = etPassword.getText().toString();
        String confirm = etConfirmPassword.getText().toString();
        return (password.equals(confirm));
    }
}