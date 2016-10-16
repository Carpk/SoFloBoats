package com.shawnklein.carpk.sofloperformanceboats;

import java.util.UUID;

public class Boat {
    private UUID mId;
    private String mTitle;
    private String mUrl;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return "http://images.boats.com/resize/1/67/68/4956768_20150302070821537_1_LARGE.jpg";
    }

    public Boat() {
        mId = UUID.randomUUID();
    }
}
