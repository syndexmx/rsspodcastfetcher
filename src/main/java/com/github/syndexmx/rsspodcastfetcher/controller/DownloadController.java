package com.github.syndexmx.rsspodcastfetcher.controller;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
@RequestMapping
public class DownloadController {

    @GetMapping
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(@RequestParam String filename) throws IOException {
        byte[] data = Files.readAllBytes( Paths.get(filename));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", filename);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);

    }

}