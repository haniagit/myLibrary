package com.hania.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {

    @GetMapping("/")
    public String home(){
        return "/homePage";
    }

    @PostMapping("/add")
    public String addBook (){
        return null;
    }
}
