package com.github.syndexmx.rsspodcastfetcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ShutdownController {

    private String SHUTDOWN_KEY = "00qp-M991";


    @GetMapping("/shutdown")
    public String showShutdownPage(Model model){
        model.addAttribute("key", "key");
        return "shutdown";
    }

    @PostMapping("/shutdown")
    public String askForShutdown(@RequestParam String key, Model model){
        if (key.equals(SHUTDOWN_KEY)){
            System.exit(0);
        } else {
            model.addAttribute("key", "key");
        }
        return "shutdown";
    }

}
