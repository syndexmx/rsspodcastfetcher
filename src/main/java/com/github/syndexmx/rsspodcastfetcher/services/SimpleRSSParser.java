package com.github.syndexmx.rsspodcastfetcher.services;

import com.github.syndexmx.rsspodcastfetcher.dto.PodcastUrl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleRSSParser implements RSSParser {

    @Override
    public List<PodcastUrl> parseRss(String rssText) {
        List<PodcastUrl> outList = new ArrayList<>();
        String text = rssText;
        StringBuilder parsedRss = new StringBuilder();
        while (text.contains("<item>")){
            text = text.substring(text.indexOf("<item>"));
            String aBlock = text.substring(0, text.indexOf("</item>")+1);

            if (aBlock.contains(".mp3")){

                String title = getTitleFromBlock(aBlock);
                String link = getUrlFromBlock(aBlock);
                String date = getDateFromBlock(aBlock);

                outList.add(new PodcastUrl(link, title, date));
            }
            text = text.substring(text.indexOf("</item>")+7);
        }
        return outList;
    }

    private String getTitleFromBlock(String aBlock){
        String title = aBlock.substring(aBlock.indexOf("<title>")+7);
        title = title.substring(0, title.indexOf("</title>"));
        title = title.replace('<','_')
                .replace('>','_')
                .replace('"','*');
        if (title.contains("[") && title.contains("]")){
            title = title.substring(title.lastIndexOf("[")+1);
            title = title.substring(0,title.lastIndexOf("]"));
        }
        return title;
    }

    private String getUrlFromBlock(String aBlock){
        String link = aBlock.substring(aBlock.indexOf("url=\"")+5);
        link = link.substring(0, link.indexOf("\""));
        return link;
    }

    private String getDateFromBlock(String aBlock){
        String date = "";
        if (aBlock.contains("<pubDate>")) {
            date = aBlock.substring(aBlock.indexOf("<pubDate>") + 9);
            date = date.substring(0, date.indexOf("</pubDate>"));
        }
        return date;
    }

}
