package com.github.syndexmx.rsspodcastfetcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.github.syndexmx.rsspodcastfetcher.externalwebservice.FileFetcher.fetchFile;
import static com.github.syndexmx.rsspodcastfetcher.services.FileNameTransformer.makeUrlIntoFilename;

@Controller
@RequestMapping
public class AcquiringController {


    @GetMapping("/acquire")
    public String acquireFile(@RequestParam String url, Model model){
        String string = makeUrlIntoFilename(url);
        model.addAttribute("filename", string);
        fetchFile(url);
        return "download";
    }


}