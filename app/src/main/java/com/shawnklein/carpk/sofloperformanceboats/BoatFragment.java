package com.shawnklein.carpk.sofloperformanceboats;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class BoatFragment extends Fragment {
    public static String EXTRA_BOAT_ID =
            "net.shawnklein.android.sofloperformanceboats.boat_id";
    private Boat mBoat;
    private TextView mTitleField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID boatId = (UUID)getArguments().getSerializable(EXTRA_BOAT_ID);

        mBoat = BoatListing.get(getActivity()).getBoat(boatId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_boat, parent, false);

        mTitleField = (TextView)v.findViewById(R.id.boat_title);
        mTitleField.setText(mBoat.getTitle());
        

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
