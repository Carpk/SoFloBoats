package com.shawnklein.carpk.sofloperformanceboats;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class BoatLoader {

    public void createList  {
        String address = "http://sofloperformanceboats.com/boats";
        String charset = "UTF-8";

        URLConnection connection = null;
        try {
            connection = new URL(address).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);

            InputStream response = connection.getInputStream();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
