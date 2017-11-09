package com.freelancing.ahmed.fondooy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotelAboutFragment extends Fragment {


    public HotelAboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_hotel_about, container, false);
        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0");
        Element adsElement = new Element();
        adsElement.setTitle("Advertise with us");
        View aboutPage = new AboutPage(this.getContext())
                .isRTL(false)
                .setDescription("larum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsumlarum ipsum")
                .setImage(R.drawable.wwwww)
                .addItem(versionElement)
                .addGroup("Connect with us")
                .addEmail("test@gmail.com")
                .addWebsite("http://www.google.com/")
                .addFacebook("facebook")
                .addTwitter("twitter")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addGitHub("Ahmeda1708")
                .addInstagram("instagram")
                .create();
         //.addPlayStore("com.ideashower.readitlater.pro")
        return (aboutPage);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("About The Hotel My Home");




    }
}
