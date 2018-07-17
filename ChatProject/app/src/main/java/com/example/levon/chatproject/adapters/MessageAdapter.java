package com.example.levon.chatproject.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.levon.chatproject.R;
import com.example.levon.chatproject.activitys.ContactsActivity;
import com.example.levon.chatproject.fragments.ChatFragment;
import com.example.levon.chatproject.models.MessageModel;
import com.example.levon.chatproject.providers.UsersDataProvider;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MessageModel> list = UsersDataProvider.listModels.get(ChatFragment.position).getList();
    private Context context;


    public MessageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.message_item_mine, parent, false);
        if (viewType == 0) {
            v = LayoutInflater.from(context).inflate(R.layout.message_item_other, parent, false);
            return new otherViewHolder(v);
        }
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel message = list.get(position);
        if (message.isMine) {
            ((myViewHolder) holder).bind(message);
        }else {
            ((otherViewHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public myViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.message_text_my);
        }
        void bind(MessageModel messageModel) {
            textView.setText(messageModel.getText().toString());
        }
    }

    class otherViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public otherViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.message_text_other);
            CircleImageView imageView = itemView.findViewById(R.id.image_other);
            Picasso.get().load(UsersDataProvider.listModels.get(ChatFragment.position).getImgUrl()).into(imageView);
        }

        void bind(MessageModel messageModel) {
            textView.setText(messageModel.getText().toString());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).isMine) {
            return 1;
        }
        return 0;
    }
}
