package com.example.levon.chatproject.adapters;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.activitys.ChatActivity;
import com.example.levon.chatproject.activitys.ContactsActivity;
import com.example.levon.chatproject.models.UsersListModel;
import com.example.levon.chatproject.providers.UsersDataProvider;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UsersListModel> modelsList = UsersDataProvider.listModels;
    private Context context;
    private int mode;
    private CircleImageView image;
    private TextView name;
    private TextView desc;

    public UsersListAdapter(Context context, int mode) {
        this.context = context;
        this.mode = mode;
        if (!(mode >= 0) || !(mode <= 2)) {
            throw new IllegalArgumentException();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.users_list_item, parent, false);
        ;
        switch (mode) {
            case 1:
                v = LayoutInflater.from(context).inflate(R.layout.user_list_item_call, parent, false);

                return new UsersCallViewHolder(v);
            case 2:
                v = LayoutInflater.from(context).inflate(R.layout.user_list_item_email, parent, false);
                return new UsersEmailViewHolder(v);
        }
        return new UsersViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (mode) {
            case 0:
                image = holder.itemView.findViewById(R.id.user_image);
                name = holder.itemView.findViewById(R.id.user_name);
                desc = holder.itemView.findViewById(R.id.user_desc);
                desc.setText(modelsList.get(position).getDescription());
                break;
            case 1:
                image = holder.itemView.findViewById(R.id.user_image_call);
                name = holder.itemView.findViewById(R.id.user_name_call);
                desc = holder.itemView.findViewById(R.id.user_desc_call);
                desc.setText(modelsList.get(position).getNumber());
                break;
            case 2:
                image = holder.itemView.findViewById(R.id.user_image_email);
                name = holder.itemView.findViewById(R.id.user_name_email);
                desc = holder.itemView.findViewById(R.id.user_desc_email);
                desc.setText(modelsList.get(position).getEmail());
                break;

        }
        Picasso.get().load(modelsList.get(position).getImgUrl()).into(image);
        name.setText(modelsList.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return modelsList.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {

        public UsersViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChatActivity.class);
                    intent.putExtra(ContactsActivity.KEY, 1);
                    intent.putExtra(ContactsActivity.KEY_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }

    public class UsersCallViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageButton;

        public UsersCallViewHolder(View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.call);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse(modelsList.get(getAdapterPosition()).getNumber()));
                    context.startActivity(callIntent);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChatActivity.class);
                    intent.putExtra(ContactsActivity.KEY, 2);
                    intent.putExtra(ContactsActivity.KEY_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

        }
    }

    public class UsersEmailViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageButton;

        public UsersEmailViewHolder(View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.email);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{modelsList.get(getAdapterPosition()).getEmail()});
                    i.putExtra(Intent.EXTRA_SUBJECT, "");
                    i.putExtra(Intent.EXTRA_TEXT   , "");
                    try {
                        context.startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChatActivity.class);
                    intent.putExtra(ContactsActivity.KEY, 2);
                    intent.putExtra(ContactsActivity.KEY_POSITION, getAdapterPosition());
                    context.startActivity(intent);
                }
            });

        }
    }

}
