package com.freelancing.ahmed.fondooy;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
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

import org.w3c.dom.Text;

import java.util.HashMap;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {

    EditText sendername,mailsubject,etmsg;
    Button btn,btn2;
    String sender,sub,msg;
    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v=inflater.inflate(R.layout.fragment_hotel, container, false);

            return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(),"NewRocker.ttf");
        TextView txt=(TextView) view.findViewById(R.id.login_title);
       // TextView txt2=(TextView) view.findViewById(R.id.login_title2);
        sendername = (EditText) view.findViewById(R.id.sendername);
        mailsubject = (EditText) view.findViewById(R.id.mailsubject);
        etmsg = (EditText) view.findViewById(R.id.etmsg);

        sender=sendername.getText().toString();
        sub=mailsubject.getText().toString();
        msg=etmsg.getText().toString();

        btn = (Button) view.findViewById(R.id.sendmsgbtn);
        btn2 = (Button) view.findViewById(R.id.callbtn);
        txt.setTypeface(myTypeface);
        txt.setTextSize(50);
        //txt2.setTypeface(myTypeface);
        btn.setTextSize(20);
        btn2.setTextSize(20);
        getActivity().setTitle("Hotel Contact");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCall();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getSharedPreferences("loginData", Context.MODE_PRIVATE);
                String mailll = (preferences.getString("email", ""));
                sender=sendername.getText().toString();
                sub=mailsubject.getText().toString();
                msg=etmsg.getText().toString();
                HashMap<String, String> postData = new HashMap<>();
                postData.put("name",sender);
                postData.put("subject",sub);
                postData.put("msg",msg);
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
                                    "Message sent successfully",
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
                loginTask.execute("http://ahmedayman1708.000webhostapp.com/fondoo2/msghotel.php");
                sendername.setText("");
                mailsubject.setText("");
                etmsg.setText("");

            }
        });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    onCall();
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
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:011")));
        }
    }
}
