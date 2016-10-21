package com.shawnklein.carpk.sofloperformanceboats;

import android.graphics.Bitmap;

import java.util.UUID;

public class Boat {
    private UUID mId;
    private String mTitle;
    private Bitmap mUrl;

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

    public Bitmap getUrl() {
        return mUrl;
    }

    public void setUrl(Bitmap url) {
        mUrl = url;
    }

    public Boat() {
        mId = UUID.randomUUID();
    }
}
