package com.shawnklein.carpk.sofloperformanceboats;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.UUID;

public class BoatFragment extends Fragment {
    public static String EXTRA_BOAT_ID = "net.shawnklein.android.sofloperformanceboats.boat_id";
    private Boat mBoat;
    private TextView mTitleField;
    private ImageView mImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID boatId = (UUID)getArguments().getSerializable(EXTRA_BOAT_ID);

        //mBoat = BoatListing.get(getActivity()).getBoat(boatId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_boat, parent, false);

        // mTitleField = (TextView)v.findViewById(R.id.boat_title);
        // mTitleField.setText(mBoat.getTitle());

        // new DownloadImageTask((ImageView)v.findViewById(R.id.boat_image)).execute(mBoat.getUrl());
        new BoatLoader( (ImageView)v.findViewById(R.id.boat_image) ).execute();
        return v;
    }

    public static BoatFragment newInstance(UUID boatId) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_BOAT_ID, boatId);

        BoatFragment fragment = new BoatFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urlDisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
