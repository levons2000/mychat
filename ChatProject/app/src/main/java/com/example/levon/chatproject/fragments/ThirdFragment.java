package com.example.levon.chatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.adapters.UsersListAdapter;
import com.example.levon.chatproject.providers.UsersDataProvider;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends Fragment {


    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.third_recycler);
        UsersListAdapter usersListAdapter = new UsersListAdapter(getContext(), 2);
        recyclerView.setAdapter(usersListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        return v;
    }

}
