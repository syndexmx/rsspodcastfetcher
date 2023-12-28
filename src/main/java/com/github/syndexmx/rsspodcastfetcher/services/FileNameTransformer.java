package com.github.syndexmx.rsspodcastfetcher.services;

public class FileNameTransformer {

    public static String makeUrlIntoFilename(String url){
        String fileName = url.substring(url.lastIndexOf("/")+1);
        return fileName;
    }

}
