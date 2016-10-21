package com.shawnklein.carpk.sofloperformanceboats;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

class BoatLoader extends AsyncTask<Void, Void, Harbor> {
    ImageView bmImage;

    public BoatLoader(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    @Override
    protected Harbor doInBackground(Void... args) {
        Bitmap bitmapResult = null;
        Harbor harbor = null;

        try {
            Document doc = Jsoup.connect("http://sofloperformanceboats.com/boats")
                    .referrer("http://sofloperformanceboats.com")
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .get();

            if (doc != null) {
                Elements elems = doc.getElementsByAttributeValue("class", "field-content");

                if (elems != null && !elems.isEmpty()) {
                    for(int i = 0; i < elems.size(); i = i + 2 ) {
                        Boat boat = new Boat();
                        Bitmap mIcon11 = null;

                        Element elem = elems.get(i);
                        elem = elem.getElementsByTag("img").first();
                        String src = elem.attr("src");
                        try {
                            InputStream in = new java.net.URL(src).openStream();
                            mIcon11 = BitmapFactory.decodeStream(in);
                            boat.setUrl(src);
                        } catch (Exception e) {
                            Log.e("Error", e.getMessage());
                            e.printStackTrace();
                        }

                        elem = elems.get(i+1);
                        String  txt = elem.text();
                        boat.setTitle(txt);

                        harbor.addBoat(boat);
                    }

                }

            }
        } catch (IOException e) {
            // Error handling goes here
        }
        return harbor;
    }


    @Override
    protected void onPostExecute(Harbor result) {

   }


}