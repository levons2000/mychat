package com.example.levon.chatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.activitys.ContactsActivity;
import com.example.levon.chatproject.models.UsersListModel;
import com.example.levon.chatproject.providers.UsersDataProvider;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformationFragment extends android.app.Fragment {


    public InformationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_information, container, false);
        CircleImageView circleImageView = v.findViewById(R.id.info_image);
        TextView textName = v.findViewById(R.id.info_name);
        TextView textDesc = v.findViewById(R.id.info_desc);
        TextView textNumber = v.findViewById(R.id.info_number);
        TextView textEmail = v.findViewById(R.id.info_email);
        UsersListModel usersListModel = UsersDataProvider.listModels.get(ChatFragment.position);
        Picasso.get().load(usersListModel.getImgUrl()).into(circleImageView);
        textName.setText(usersListModel.getName());
        textDesc.setText(usersListModel.getDescription());
        textNumber.setText(usersListModel.getNumber());
        textEmail.setText(usersListModel.getEmail());

        return v;
    }

}
