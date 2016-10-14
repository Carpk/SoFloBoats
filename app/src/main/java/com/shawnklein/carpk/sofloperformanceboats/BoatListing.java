package com.shawnklein.carpk.sofloperformanceboats;

import android.content.Context;
import java.util.ArrayList;

public class BoatListing {
    private ArrayList<Boat> mBoats;

    private BoatListing(Context appContext) {
        mBoats = new ArrayList<Boat>();
        for (int i = 0; i < 3; i++) {
            Boat b = new Boat();
            b.setTitle("Boat #" + i);
            mBoats.add(b);
        }
    }



    public ArrayList<Boat> getBoats() {
        return mBoats;
    }
}
