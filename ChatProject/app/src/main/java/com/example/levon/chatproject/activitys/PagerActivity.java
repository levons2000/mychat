package com.example.levon.chatproject.activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.adapters.ViewPagerAdapter;
import com.example.levon.chatproject.models.ViewPagerModel;
import android.view.View.OnScrollChangeListener;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;

public class PagerActivity extends AppCompatActivity {

    private List<ViewPagerModel> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        final ViewPager viewPager = findViewById(R.id.act_pager_pager);
        final TabLayout tabLayout = findViewById(R.id.act_pager_tab);
        listFiller(list);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(list, PagerActivity.this);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_gps_fixed_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
        viewPager.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                tabLayout.getTabAt(viewPager.getCurrentItem()).setIcon(R.drawable.ic_gps_fixed_black_24dp);
                switch (viewPager.getCurrentItem()) {
                    case 0:
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        break;
                    case 1:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        break;
                    case 2:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(3).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        break;
                    case 3:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(1).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        tabLayout.getTabAt(2).setIcon(R.drawable.ic_gps_not_fixed_black_24dp);
                        break;
                }
            }
        });

    }

    private void listFiller(List<ViewPagerModel> list){
        list.add(new ViewPagerModel("https://www.candb.com/site/candb/cache/artwork/1600/high-wall-of-lothric-dark-souls-3-from-software_1600x938_marked.jpg"));
        list.add(new ViewPagerModel("https://cdn.wccftech.com/wp-content/uploads/2017/12/assassins-creed-rogue-hd.jpg"));
        list.add(new ViewPagerModel("https://media.kg-portal.ru/games/w/witcher3/images/witcher3_22.jpg"));
        list.add(new ViewPagerModel("http://gamebomb.ru/files/galleries/001/4/46/207388.jpg"));
    }
}
