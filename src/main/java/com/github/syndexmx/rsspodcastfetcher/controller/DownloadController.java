package com.github.syndexmx.rsspodcastfetcher.controller;



import com.github.syndexmx.rsspodcastfetcher.dto.PodcastUrl;
import com.github.syndexmx.rsspodcastfetcher.externalwebservice.RssFetcher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.github.syndexmx.rsspodcastfetcher.services.FileNameTransformer.urlToSubpathFilename;

@Controller
@RequestMapping
public class DownloadController {

    private byte[] ERROR_MESSAGE_BYTE_ARRAY = {(byte)'E', (byte)'r', (byte)'r', (byte)'o',
            (byte)'r',(byte)'!'} ;

    @GetMapping
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(@RequestParam String filename) throws IOException {
        byte[] data = Files.readAllBytes( Paths.get(urlToSubpathFilename(filename)));
        if (filename.contains("" + File.separatorChar)) {
            data = ERROR_MESSAGE_BYTE_ARRAY;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", filename);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping(value = "/delete")
    public String showImportRSSPage(@RequestParam String filename, Model model) {
        try {
            Files.deleteIfExists(Paths.get( urlToSubpathFilename(filename)  ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("filename", filename);
        return "deleted";
    }
}