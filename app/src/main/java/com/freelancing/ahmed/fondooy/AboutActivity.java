package com.freelancing.ahmed.fondooy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutActivity extends Fragment {


    public AboutActivity() {
        // Required empty public constructor
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_about_city:
                    CityAboutFragment cityAboutFragment=new CityAboutFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentLayout2,cityAboutFragment).commit();
                    return true;
                case R.id.navigation_about_hotel:
                    HotelAboutFragment hotelAboutFragment=new HotelAboutFragment();
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.contentLayout2,hotelAboutFragment).commit();
                    return true;

            }
            return false;
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_about, container, false);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation2);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CityAboutFragment cityAboutFragment=new CityAboutFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.contentLayout2,cityAboutFragment).commit();

    }


}
