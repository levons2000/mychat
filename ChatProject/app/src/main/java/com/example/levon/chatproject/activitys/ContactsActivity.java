package com.example.levon.chatproject.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.adapters.FragmentPagerAdapter;
import com.example.levon.chatproject.fragments.FirstFragment;
import com.example.levon.chatproject.fragments.SecondFragment;
import com.example.levon.chatproject.fragments.ThirdFragment;
import com.example.levon.chatproject.providers.UsersDataProvider;

public class ContactsActivity extends AppCompatActivity {

    public static final String KEY = "privetik";
    public static final String KEY_POSITION = "positon";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager = findViewById(R.id.act_contacts_pager);
        TabLayout tabLayout = findViewById(R.id.act_contacts_tab);
        final FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager());
        fragmentPagerAdapter.addFragment(new FirstFragment());
        fragmentPagerAdapter.addFragment(new SecondFragment());
        fragmentPagerAdapter.addFragment(new ThirdFragment());
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_forum_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_phone_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_email_black_24dp);
        UsersDataProvider.listFill();

    }
}
