package com.example.levon.chatproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.activitys.ContactsActivity;
import com.example.levon.chatproject.adapters.MessageAdapter;
import com.example.levon.chatproject.models.MessageModel;
import com.example.levon.chatproject.providers.UsersDataProvider;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends android.app.Fragment {

    public static int position;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        position = getArguments().getInt(ContactsActivity.KEY_POSITION);
        CircleImageView imageView = v.findViewById(R.id.chat_user_image);
        TextView textName = v.findViewById(R.id.chat_user_name);
        TextView textDesc = v.findViewById(R.id.chat_user_description);
        Picasso.get().load(UsersDataProvider.listModels.get(position).getImgUrl()).into(imageView);
        textName.setText(UsersDataProvider.listModels.get(position).getName());
        textDesc.setText(UsersDataProvider.listModels.get(position).getDescription());
        final MessageAdapter messageAdapter = new MessageAdapter(getActivity());
        RecyclerView recyclerView = v.findViewById(R.id.message_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true));
        recyclerView.setAdapter(messageAdapter);
        final EditText editText = v.findViewById(R.id.writetext);
        ImageButton imageButton = v.findViewById(R.id.sendmessage);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsersDataProvider.listModels.get(position).setMessage(new MessageModel(editText.getText().toString(), true));
                UsersDataProvider.listModels.get(position).setMessage(new MessageModel("Buy our games!", false));
                messageAdapter.notifyDataSetChanged();
                editText.setText("");

            }
        });
        return v;
    }

}
