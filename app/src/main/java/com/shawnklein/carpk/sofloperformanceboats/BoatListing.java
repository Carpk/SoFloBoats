package com.shawnklein.carpk.sofloperformanceboats;

import android.content.Context;
import java.util.ArrayList;
import java.util.UUID;

public class BoatListing {
    private ArrayList<Boat> mBoats;
    private static BoatListing sBoatListing;

    private BoatListing(Context appContext) {
        mBoats = new ArrayList<Boat>();
        for (int i = 0; i < 3; i++) {
            Boat b = new Boat();
            b.setTitle("Boat #" + i);
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
