package com.example.levon.chatproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.activitys.ContactsActivity;
import com.example.levon.chatproject.models.ViewPagerModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter{

    private List<ViewPagerModel> list;
    private Context context;

    public ViewPagerAdapter(List<ViewPagerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_pager_item, container, false);
        ImageButton imageButton = v.findViewById(R.id.pager_close);
        ImageView imageView = v.findViewById(R.id.view_pager_image);
        Picasso.get().load(list.get(position).getImgUrl()).into(imageView);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContactsActivity.class);
                context.startActivity(intent);
            }
        });
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
