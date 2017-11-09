package com.freelancing.ahmed.fondooy;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityAboutFragment extends Fragment {
    TextView tit,desc;

    public CityAboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_city_about, container, false);

        return (view);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("About Hurghada");
        Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(), "MerryChristmasStar.ttf");
        Typeface myTypeface2 = Typeface.createFromAsset(getActivity().getAssets(), "imfe.ttf");
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(), "juni.ttf");

        tit = (TextView) view.findViewById(R.id.tit);
        desc = (TextView) view.findViewById(R.id.desc);
        tit.setTypeface(myTypeface);
        desc.setTypeface(face);

    }
}
