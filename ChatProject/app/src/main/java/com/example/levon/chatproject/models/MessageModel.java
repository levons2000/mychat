package com.example.levon.chatproject.models;

public class MessageModel {
    private String text;
    public boolean isMine;

    public MessageModel(String text, boolean isMine) {
        this.text = text;
        this.isMine = isMine;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
