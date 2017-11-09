package com.freelancing.ahmed.fondooy;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView mail;
    String texture;
    Button mcancel,mcall,memail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        SharedPreferences preferences = getSharedPreferences("loginData", Context.MODE_PRIVATE);
        String channel = (preferences.getString("email", ""));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header_main2, navigationView, false);
        //View headerView = navigationView.getHeaderView(0);
        navigationView.addHeaderView(headerView);
        TextView Name = (TextView) headerView.findViewById(R.id.name);
        Name.setText("Welcome,");
        TextView Number = (TextView) headerView.findViewById(R.id.mailsssss);
        Number.setText(channel);
        navigationView.setNavigationItemSelectedListener(this);
        HomeMainFragment homeMainFragment=new HomeMainFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainLayout,homeMainFragment).commit();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else  if (getSupportFragmentManager().findFragmentByTag("Frag1") != null) {
           // getSupportFragmentManager().popBackStackImmediate("Frag1",0);
            HomeMainFragment homeMainFragment=new HomeMainFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.mainLayout,homeMainFragment).commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SharedPreferences preferences = getSharedPreferences("loginData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if  (id == R.id.logout) {
                    SharedPreferences preferences = getSharedPreferences("loginData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();
                    Intent i = new Intent(this,LoginActivity.class);
                    startActivity(i);
                    finish();

        } else if (id == R.id.nav_map) {
            HomeFragment contactusFragment=new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.mainLayout,contactusFragment).addToBackStack("Frag1").commit();

        } else if (id == R.id.nav_home){
            HomeMainFragment homeMainFragment=new HomeMainFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.mainLayout,homeMainFragment).commit();


        } else if (id == R.id.nav_requestcar){
            GoToURL("https://www.vipcars.com/?viplang=ar&country=48&city=443");


        } else if (id == R.id.nav_services){
            innerActivity innerFragment=new innerActivity();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.mainLayout,innerFragment).addToBackStack("Frag1").commit();

        } else if (id == R.id.nav_ContactTourism){
            TourismFragment tourismFragment=new TourismFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.mainLayout,tourismFragment).addToBackStack("Frag1").commit();

        } else if (id == R.id.nav_ContactHotel){

            HotelFragment HotelFragment=new HotelFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.mainLayout,HotelFragment).addToBackStack("Frag1").commit();


        } else if (id == R.id.About){
            AboutActivity aboutActivity=new AboutActivity();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.mainLayout,aboutActivity).addToBackStack("Frag1").commit();

        }









        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void GoToURL(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
