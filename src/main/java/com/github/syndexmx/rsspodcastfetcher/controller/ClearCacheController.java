package com.github.syndexmx.rsspodcastfetcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@Controller
@RequestMapping
public class ClearCacheController {

    private String CLEARCACHE_KEY = "00W1";
    // TODO : Ввести причичное адсминистрирование

    @GetMapping
    @RequestMapping(value = "/clearcache")
    public String showClearCachePage(Model model){
        model.addAttribute("key", "key");
        return "clearcache";
    }

    @DeleteMapping
    @RequestMapping(value = "/deletecachefiles")
    public String clearCacheFiles(@RequestParam String key, Model model) {
        if (key.equals(CLEARCACHE_KEY)) {
            for (File myFile : new File("downloads").listFiles())
                if (myFile.isFile()) myFile.delete();
            model.addAttribute("key", "key");
        } else {
            model.addAttribute("key", "Не верный ключ!");
        }
        return "deleted";
    }

}
