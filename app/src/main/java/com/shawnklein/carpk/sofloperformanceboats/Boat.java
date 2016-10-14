package com.shawnklein.carpk.sofloperformanceboats;

import java.util.UUID;

public class Boat {
    private UUID mId;
    private String mTitle;

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
}
