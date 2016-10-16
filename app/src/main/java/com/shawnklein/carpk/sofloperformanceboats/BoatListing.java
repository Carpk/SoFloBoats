package com.shawnklein.carpk.sofloperformanceboats;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

public class BoatListing {
    private ArrayList<Boat> mBoats;
    private static BoatListing sBoatListing;

    private BoatListing(Context appContext) {
        mBoats = new ArrayList<Boat>();
        String[] boatArrayUrls = {"http://images.boats.com/resize/1/0/10/5080010_20150505140842676_1_LARGE.jpg",
                "http://images.boats.com/resize/1/62/41/4096241_-1_20121003075030_4_0.jpg",
                "http://images.boats.com/resize/1/19/2/5771902_20160411201510914_1_LARGE.jpg"};
        for (int i = 0; i < 3; i++) {
            Boat b = new Boat();
            b.setTitle("Boat #" + i);
            b.setUrl(boatArrayUrls[i]);
            mBoats.add(b);
        }
    }

    public static BoatListing get(Context c) {
        if (sBoatListing == null) {
            sBoatListing = new BoatListing(c.getApplicationContext());
        }
        return sBoatListing;
    }



    public ArrayList<Boat> getBoats() {
        return mBoats;
    }

    public Boat getBoat(UUID id) {
        for (Boat b : mBoats) {
            if (b.getId().equals(id))
                return b;
        }
        return null;
    }
}
