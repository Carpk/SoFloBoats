package com.shawnklein.carpk.sofloperformanceboats;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

public class BoatListing {
    private ArrayList<Boat> mBoats;
    private static BoatListing sBoatListing;

    private BoatListing(Context appContext) {
        mBoats = new ArrayList<Boat>();
        String[] boatArrayUrls = {"http://media.channelblade.com/boat_graphics/dealers/40524/digi55489199_l.jpg",
                "http://media.channelblade.com/boat_graphics/dealers/40524/digi56183663_l.jpg",
                "http://media.channelblade.com/boat_graphics/dealers/40524/digi55489191_l.jpg",
                "http://images.boats.com/resize/1/5/12/4710512_20140521135437105_1_LARGE.jpg"};

        for (int i = 0; i < boatArrayUrls.length; i++) {
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
