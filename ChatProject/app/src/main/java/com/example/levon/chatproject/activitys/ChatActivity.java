package com.example.levon.chatproject.activitys;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.fragments.ChatFragment;
import com.example.levon.chatproject.fragments.InformationFragment;

public class ChatActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        fragmentManager = getFragmentManager();
        position = intent.getExtras().getInt(ContactsActivity.KEY_POSITION);
        setFragment(intent.getExtras().getInt(ContactsActivity.KEY));


    }

    private void setFragment(int a) {
        Bundle bundle = new Bundle();
        bundle.putInt(ContactsActivity.KEY_POSITION,position);
        switch (a) {
            case 1:
                ChatFragment chatFragment = new ChatFragment();
                chatFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.container_for_chat, chatFragment).commit();
                break;
            case 2:
                InformationFragment informationFragment = new InformationFragment();
                informationFragment.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.container_for_chat, informationFragment).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
