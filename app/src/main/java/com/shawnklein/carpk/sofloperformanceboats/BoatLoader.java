package com.shawnklein.carpk.sofloperformanceboats;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

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
            //parse("http://lulpix.com");
            if (doc != null) {
                Elements elems = doc.getElementsByAttributeValue("typeof", "foaf:Image");
                System.out.println("ELEMENTS ARE " + elems.toString());
                if (elems != null && !elems.isEmpty()) {
                    Element elem = elems.first();
                    elems = elem.getElementsByTag("img");
                    if (elems != null && !elems.isEmpty()) {
                        elem = elems.first();
                        String src = elem.attr("src");
                        if (src != null) {
                            URL url = new URL(src);
                            // Just assuming that "src" isn't a relative URL is probably stupid.
                            InputStream is = url.openStream();

                            try {
                                result = BitmapFactory.decodeStream(is);
                            } finally {
                                is.close();
                            }
                        }
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