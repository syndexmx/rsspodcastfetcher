package com.github.syndexmx.rsspodcastfetcher.dto;
import java.io.Serializable;

public class PodcastUrl implements Serializable {

    public static int DESCRIPTION_LENGTH_LIMIT=400;

    public String url;
    public String title;
    public String description;
    public String date;

    public PodcastUrl(String url, String title, String date, String description) {
        this.url = url;
        this.title = title;
        this.date = date;
        this.description = description;
    }
}
