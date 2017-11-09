package com.freelancing.ahmed.fondooy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowsFragment extends Fragment {


    public ShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_list_show, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Our Shows");
        /* ListFragment fragTwo = new ListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, fragTwo);
        fragmentTransaction.commit();*/
        // find your RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView2);
        // declare an object from the adabter class
        ShowsListAdapter listAdapter = new ShowsListAdapter();
        //Attach a Layout Manager to it
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getActivity().getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        //Add Adapter to the recyclerview
        recyclerView.setAdapter(listAdapter);
    }
}
