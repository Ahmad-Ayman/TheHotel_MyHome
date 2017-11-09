package com.freelancing.ahmed.fondooy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {


    private TextView tv;
    String emailStored = "", passwordStored = "";
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        tv=(TextView)findViewById(R.id.txtview1);
        iv=(ImageView) findViewById(R.id.image1);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanim);
        iv.startAnimation(myanim);
        Typeface myTypeface = Typeface.createFromAsset(this.getAssets(), "harry.ttf");
        tv.setTypeface(myTypeface);
        tv.setTextSize(50);
        final Intent i = new Intent(this,LoginActivity.class);
        final Intent i2 = new Intent (this,Main2Activity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    SharedPreferences pref = getSharedPreferences("loginData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    //editor.clear();  //for bebugging
                    //editor.commit(); //for bebugging
                    emailStored = pref.getString("email", null);
                    passwordStored = pref.getString("password", null);
                    if(emailStored == null){
                        startActivity(i);
                    }else{
                        startActivity(i2);
                    }

                    finish();
                }
            }
        };
        timer.start();
    }
}
