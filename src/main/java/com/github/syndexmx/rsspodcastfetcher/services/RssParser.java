package com.github.syndexmx.rsspodcastfetcher.services;

import com.github.syndexmx.rsspodcastfetcher.dto.PodcastUrl;

import java.util.List;

public interface RssParser {

    List<PodcastUrl> parseRss(String string);
}
