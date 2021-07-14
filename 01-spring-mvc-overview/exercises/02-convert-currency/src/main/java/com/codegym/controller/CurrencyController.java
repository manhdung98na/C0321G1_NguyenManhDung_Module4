package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public String showForm(){
        return "/index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("rate") float rate, @RequestParam("usd") float usd, Model model){
        System.out.println(rate);
        System.out.println(usd);
        float vnd = rate * usd;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "/result";
    }
}
