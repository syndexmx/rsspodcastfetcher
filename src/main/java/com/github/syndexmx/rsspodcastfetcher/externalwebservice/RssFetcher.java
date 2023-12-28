package com.github.syndexmx.rsspodcastfetcher.externalwebservice;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.*;

public class RssFetcher {

    static private int TIME_OUT_MILLIS = 5000;

    public static String getPage(String url) {

        try {
            URL website = new URL(url);
            URLConnection connection = website.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();

            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

}
