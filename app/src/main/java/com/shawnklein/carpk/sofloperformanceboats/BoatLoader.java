package com.shawnklein.carpk.sofloperformanceboats;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

class BoatLoader extends AsyncTask<Void, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(Void... args) {
        Bitmap result = null;
        try {
            Document doc = Jsoup.connect("http://sofloperformanceboats.com/boats")
                    .referrer("http://www.google.com")
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .get();

            if (doc != null) {
                //Elements elems = doc.getElementsByAttributeValue("typeof", "foaf:Image");
                Elements elems = doc.getElementsByAttributeValue("class", "field-content");

                if (elems != null && !elems.isEmpty()) {
                    for(int i = 0; i < elems.size(); i = i + 2 ) {
                        Boat boat = new Boat();
                        Element elem = elems.get(i);
                        elem = elem.getElementsByTag("img").first();
                        String src = elem.attr("src");
                        boat.setUrl(src);
                        //if (elem != null && !elems.isEmpty()) {
                        //    String src = elem.attr("src");
                        //    if (src != null) {
                        //        System.out.println(src);
                        //        URL url = new URL(src);
                        //        InputStream is = url.openStream();

                        //        try {
                        //            result = BitmapFactory.decodeStream(is);
                        //            boat.setUrl(result);
                        //        } finally {
                        //            is.close();
                        //        }
                        //    }
                        //}
                        elem = elems.get(i+1);
                        String  txt = elem.text();
                        boat.setTitle(txt);
                        //elems = elem.getElementsByTag("img");

                        //Harbor.addBoat(boat);
                    }
                }



            }
        } catch (IOException e) {
            // Error handling goes here
        }
        return result;
    }


    @Override
    protected void onPostExecute(Bitmap result) {
        //ImageView lulz = (ImageView) findViewById(R.id.boat_image);
        //if (result != null) {
        //    lulz.setImageBitmap(result);
        //} else {
        //    //Your fallback drawable resource goes here
        //    //lulz.setImageResource(R.drawable.nolulzwherehad);
       // }
    }
}