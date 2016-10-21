package com.shawnklein.carpk.sofloperformanceboats;



import java.util.ArrayList;

public class Harbor {
    private ArrayList<Boat> mBoats;


    public void addBoat(Boat boat) {
        if (mBoats == null) {
            mBoats = new ArrayList<Boat>();
        }
        mBoats.add(boat);
        System.out.println("THIS IS MY HARBOR: " + mBoats.size());
    }

    public ArrayList<Boat> getBoats() {
        return mBoats;
    }
}
