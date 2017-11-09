package com.freelancing.ahmed.fondooy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class innerActivity extends Fragment {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    FoodFragment foodFragment=new FoodFragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.contentLayout,foodFragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    ShowsFragment showsFragment=new ShowsFragment();
                    FragmentManager manager2 = getFragmentManager();
                    manager2.beginTransaction().replace(R.id.contentLayout,showsFragment).commit();
                    return true;

            }
            return false;
        }

    };

    public innerActivity() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_inner, container, false);
        FoodFragment foodFragment=new FoodFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.contentLayout,foodFragment).commit();
        return v;



    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        BottomNavigationView navigation = (BottomNavigationView) view.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FoodFragment foodFragment=new FoodFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.contentLayout,foodFragment).commit();
    }
}
