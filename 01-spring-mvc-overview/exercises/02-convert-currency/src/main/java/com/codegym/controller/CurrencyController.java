package com.codegym.controller;

import com.codegym.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping("/")
    public String showForm(){
        return "/index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("rate") float rate, @RequestParam("usd") float usd, Model model){
        float vnd = currencyService.convert(usd,rate);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "/result";
    }
}
