package com.shawnklein.carpk.sofloperformanceboats;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

public class BoatListing {
    private ArrayList<Boat> mBoats;
    private static BoatListing sBoatListing;

    private BoatListing(Context appContext) {
        mBoats = new ArrayList<Boat>();
        String[] boatArrayUrls = {"http://sofloperformanceboats.com/sites/default/files/styles/boats_thumbnail/public/DSC_0693.jpg",
                "http://sofloperformanceboats.com/sites/default/files/styles/boats_thumbnail/public/2016-01-21%2009.40.32.jpg?itok=yWpwjCbD",
                "http://sofloperformanceboats.com/sites/default/files/styles/boats_thumbnail/public/392_Super_Fish.jpg?itok=pTIF6R0j",
                "http://sofloperformanceboats.com/sites/default/files/styles/boats_thumbnail/public/4688883_20150121084153021_1_XLARGE.jpg?itok=yifTNXF0",
                "http://sofloperformanceboats.com/sites/default/files/styles/boats_thumbnail/public/IMG_3544A_0.jpg?itok=58ZN7Awp"};

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
