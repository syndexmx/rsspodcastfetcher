package com.github.syndexmx.rsspodcastfetcher.dto;
import java.io.Serializable;

public class PodcastUrl implements Serializable {

    public String url;
    public String title;
    public String date;

    public PodcastUrl(String url, String title, String date) {
        this.url = url;
        this.title = title;
        this.date = date;
    }
}
