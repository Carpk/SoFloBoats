package com.shawnklein.carpk.sofloperformanceboats;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.UUID;

public class BoatFragment extends Fragment {
    public static String EXTRA_BOAT_ID =
            "net.shawnklein.android.sofloperformanceboats.boat_id";
    private Boat mBoat;

    @Override
    public void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_boat, parent, false);

        return v;
    }

    public static BoatFragment newInstance(UUID boatId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_BOAT_ID, boatId);

        BoatFragment fragment = new BoatFragment();
        fragment.setArguments(args);

        return fragment;
    }
}
