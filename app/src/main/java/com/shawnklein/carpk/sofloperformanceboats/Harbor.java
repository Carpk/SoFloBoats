package com.shawnklein.carpk.sofloperformanceboats;

import android.content.Context;
import android.os.AsyncTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class Harbor {
    private ArrayList<Boat> mBoats;
    private static Harbor sHarbor;

    private Harbor(Context appContext) {
        mBoats = new ArrayList<Boat>();
        try {
            new BoatUrlLoader().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) {
            e.printStackTrace();
        }
    }

    public void addBoat(Boat boat) {
        if (mBoats == null) {
            mBoats = new ArrayList<Boat>();
        }
        mBoats.add(boat);
    }

    public static Harbor get(Context c) {
        if (sHarbor == null) {
            sHarbor = new Harbor(c.getApplicationContext());
        }
        return sHarbor;
    }

    public ArrayList<Boat> getBoats() {
        return mBoats;
    }

    public Boat getBoat(UUID id) {
        for (Boat b : mBoats) {
            if (b.getId().equals(id))
                return b;
        }
        return null;
    }

    class BoatUrlLoader extends AsyncTask<Void, Void, ArrayList> {

        @Override
        protected ArrayList<Boat> doInBackground(Void... args) {
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

                            Element elem = elems.get(i);
                            elem = elem.getElementsByTag("img").first();
                            String src = elem.attr("src");
                            boat.setUrl(src);

                            elem = elems.get(i+1);
                            String  txt = elem.text();
                            boat.setTitle(txt);

                            mBoats.add(boat);
                        }
                    }
                }
            } catch (IOException e) {
                // Error handling goes here
            }
            return mBoats;
        }

        @Override
        protected void onPostExecute(ArrayList list) {
        }
    }
}
