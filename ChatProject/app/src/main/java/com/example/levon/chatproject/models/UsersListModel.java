package com.example.levon.chatproject.models;

import java.util.ArrayList;
import java.util.List;

public class UsersListModel {
    private String name;
    private String description;
    private String imgUrl;
    private String number;
    private String email;
    private List<MessageModel> list = new ArrayList<>();

    public UsersListModel(String name, String description, String imgUrl, String number, String email) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.number = number;
        this.email = email;
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MessageModel> getList() {
        return list;
    }

    public void setMessage(MessageModel message) {
        list.add(message);
    }
    public MessageModel getMessage(int position){
        return list.get(position);
    }
}
