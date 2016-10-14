package com.shawnklein.carpk.sofloperformanceboats;

import android.support.v4.app.Fragment;
import java.util.UUID;

public class BoatFragment extends Fragment {
    public static String EXTRA_BOAT_ID =
            "net.shawnklein.android.sofloperformanceboats.boat_id";
    private Boat mBoat;

    public static BoatFragment newInstance(UUID boatId) {
        BoatFragment fragment = new BoatFragment();
        return fragment;
    }
}
