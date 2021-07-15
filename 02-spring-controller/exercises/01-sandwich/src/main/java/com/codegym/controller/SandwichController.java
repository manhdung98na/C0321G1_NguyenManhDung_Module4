package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {

    @RequestMapping()
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiments") String[] condiments, Model model) {
        String result = "";
        for (int i = 0; i < condiments.length; i++) {
            result += condiments[i];
            if (i != condiments.length - 1) {
                result += ", ";
            }
        }
        if (!result.equals("")) {
            result = "Condiments: " + result;
            System.out.println(result);
            model.addAttribute("result", result);
        }
        return "index";
    }
}
