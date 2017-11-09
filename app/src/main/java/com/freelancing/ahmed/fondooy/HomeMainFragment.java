package com.freelancing.ahmed.fondooy;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeMainFragment extends Fragment {

    ImageView maps,rent,food,contacting;
    TextView maps2,rent2,food2,contacting2;
    public HomeMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Home Page");
        maps = (ImageView) view.findViewById(R.id.mp);
        maps2 = (TextView) view.findViewById(R.id.mp2);
        rent = (ImageView) view.findViewById(R.id.re);
        rent2 = (TextView) view.findViewById(R.id.re2);
        food = (ImageView) view.findViewById(R.id.fo);
        food2 = (TextView) view.findViewById(R.id.fo2);
        contacting = (ImageView) view.findViewById(R.id.co);
        contacting2 = (TextView) view.findViewById(R.id.co2);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment contactusFragment=new HomeFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.mainLayout,contactusFragment).addToBackStack("Frag1").commit();

            }
        });

        maps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment contactusFragment=new HomeFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.mainLayout,contactusFragment).addToBackStack("Frag1").commit();

            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.vipcars.com/?viplang=ar&country=48&city=443"));
                startActivity(i);
            }
        });

        rent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.vipcars.com/?viplang=ar&country=48&city=443"));
                startActivity(i);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                innerActivity innerFragment=new innerActivity();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.mainLayout,innerFragment).addToBackStack("Frag1").commit();

            }
        });

        food2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                innerActivity innerFragment=new innerActivity();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.mainLayout,innerFragment).addToBackStack("Frag1").commit();

            }
        });

        contacting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelFragment HotelFragment=new HotelFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.mainLayout,HotelFragment).addToBackStack("Frag1").commit();

            }
        });

        contacting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HotelFragment HotelFragment=new HotelFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.mainLayout,HotelFragment).addToBackStack("Frag1").commit();

            }
        });

    }
}
