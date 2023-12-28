package com.github.syndexmx.rsspodcastfetcher.services;

import java.io.File;

public class FileNameTransformer {

    private static String DOWNLOAD_DIRECTORY = "downloads";

    public static String makeUrlIntoFilename(String url){
        String fileName = url;
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        return fileName;
    }

    public static String urlToSubpathFilename(String url){
        String fileName = url;
        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        fileName = DOWNLOAD_DIRECTORY + File.separatorChar + fileName;
        return fileName;
    }

}
