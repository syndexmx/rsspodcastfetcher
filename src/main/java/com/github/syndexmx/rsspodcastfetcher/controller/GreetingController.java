package com.github.syndexmx.rsspodcastfetcher.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GreetingController {

    //TODO : Ввести аутентификацию

    @GetMapping("")
    public String showGreetingPage(Model model){
        model.addAttribute("greeting", "");
        return "greeting";
    }


}