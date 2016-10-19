package com.shawnklein.carpk.sofloperformanceboats;


import java.util.ArrayList;

public class Harbor {
    // This class will be the successor to BoatListing
    private ArrayList<Boat> mBoats;
    private static Harbor sHarbor;

    //private Harbor() {
    //    sHarbor;
    //}

    public void addBoat(Boat boat) {
        mBoats.add(boat);
    }
}
