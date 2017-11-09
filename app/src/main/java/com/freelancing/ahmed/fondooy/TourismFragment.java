package com.freelancing.ahmed.fondooy;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.ExceptionHandler;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class TourismFragment extends Fragment {
    final String TAG = "Tourism Activity";
    Button btn,btn2;
    String callno;
    public String callernumber;
    EditText sendername2,mailsubject2,etmsg2;

    String sender2,sub2,msg2;

    public TourismFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_tourism, container, false);
        //Back pressed Logic for fragment

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "NewRocker.ttf");
        getActivity().setTitle("Tourism Company Contact");
        TextView txt = (TextView) view.findViewById(R.id.login_title2);
        sendername2 = (EditText) view.findViewById(R.id.sendername2);
        mailsubject2 = (EditText) view.findViewById(R.id.mailsubject2);
        etmsg2 = (EditText) view.findViewById(R.id.etmsg2);

        sender2=sendername2.getText().toString();
        sub2=mailsubject2.getText().toString();
        msg2=etmsg2.getText().toString();

        btn = (Button) view.findViewById(R.id.sendmsgbtn2);
        btn2 = (Button) view.findViewById(R.id.callbtn2);
        txt.setTypeface(myTypeface);
        txt.setTextSize(40);
        btn.setTextSize(20);
        btn2.setTextSize(20);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("loginData", Context.MODE_PRIVATE);
                String mailll = (preferences.getString("email", ""));
                sender2=sendername2.getText().toString();
                sub2=mailsubject2.getText().toString();
                msg2=etmsg2.getText().toString();
                HashMap<String, String> postData = new HashMap<>();
                postData.put("name",sender2);
                postData.put("subject",sub2);
                postData.put("msg",msg2);
                postData.put("email", mailll);

                PostResponseAsyncTask loginTask = new PostResponseAsyncTask(getActivity(),
                        postData, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        if(s=="ErrorInsert"){
                            Toast.makeText(getContext(),
                                    "Something went wrong. Data was not inserted.",
                                    Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getContext(),
                                    "Mail sent successfully",
                                    Toast.LENGTH_LONG).show();
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
                loginTask.execute("http://ahmedayman1708.000webhostapp.com/fondoo2/msgcompany.php");
                sendername2.setText("");
                mailsubject2.setText("");
                etmsg2.setText("");

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("loginData", Context.MODE_PRIVATE);
                String channel = (preferences.getString("email", ""));
                HashMap<String, String> loginData = new HashMap<>();
                loginData.put("email", channel);
                PostResponseAsyncTask loginTask = new PostResponseAsyncTask(getActivity(),
                        loginData, new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        Log.d(TAG, s);
                        callno = s;
                        callernumber=callno;
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
                loginTask.execute("http://ahmedayman1708.000webhostapp.com/fondoo2/call.php");
                onCall();
            }


        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    onCall();
                    Log.d("TAG", callno);
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;

            default:
                break;
        }
    }
    public void onCall() {
        int permissionCheck = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this.getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+callernumber)));
        }
    }

    /*public void call_action(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" +callno));
        startActivity(intent);
    } */
}
