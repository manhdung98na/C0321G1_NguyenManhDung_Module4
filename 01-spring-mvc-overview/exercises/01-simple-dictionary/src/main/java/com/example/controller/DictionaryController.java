package com.example.controller;

import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class DictionaryController {
    @GetMapping("/")
    public String showForm() {
        return "/index";
    }

    @Autowired
    DictionaryService dictionaryService;

    @PostMapping("/translate")
    public String translate(@RequestParam("txtSearch") String txtSearch, Model model) {
        String result = dictionaryService.translate(txtSearch);
        model.addAttribute("txtSearch", txtSearch);
        model.addAttribute("result", result);
        return "/result";
    }
}
