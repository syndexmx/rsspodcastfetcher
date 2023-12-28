package com.github.syndexmx.rsspodcastfetcher.controller;


import com.github.syndexmx.rsspodcastfetcher.dto.PodcastUrl;
import com.github.syndexmx.rsspodcastfetcher.externalwebservice.RssFetcher;
import com.github.syndexmx.rsspodcastfetcher.services.RSSParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class RssImportController {

    @Autowired
    RSSParser rssParser;

    @PostMapping("/rss")
    public String showImportRSSPage(@RequestParam String url, Model model){
        String rssText = RssFetcher.getPage(url);
        List<PodcastUrl> listOfUrls = rssParser.parseRss(rssText);
        model.addAttribute("channelname", url);
        model.addAttribute("podcastlist", listOfUrls);
        return "parsedrss";
    }


}