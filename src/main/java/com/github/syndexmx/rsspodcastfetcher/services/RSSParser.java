package com.github.syndexmx.rsspodcastfetcher.services;

import com.github.syndexmx.rsspodcastfetcher.dto.PodcastUrl;

import java.util.List;

public interface RSSParser {

    List<PodcastUrl> parseRss(String string);

}
