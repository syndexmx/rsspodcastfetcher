package com.github.syndexmx.rsspodcastfetcher.externalwebservice;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

import static com.github.syndexmx.rsspodcastfetcher.services.FileNameTransformer.makeUrlIntoFilename;
import static com.github.syndexmx.rsspodcastfetcher.services.FileNameTransformer.urlToSubpathFilename;

public class FileFetcher {


    public static void fetchFile(String url){
        try {
            FileUtils.copyURLToFile(
                    new URL(url), new File( urlToSubpathFilename(url)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
