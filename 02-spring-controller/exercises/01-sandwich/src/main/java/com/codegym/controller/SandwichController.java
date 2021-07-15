package com.codegym.controller;

import com.codegym.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    @Autowired
    SandwichService sandwichService;
    @RequestMapping()

    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiments") String[] condiments, Model model) {
        String result = sandwichService.getCondiments(condiments);
        model.addAttribute("result",result);
        return "index";
    }
}
