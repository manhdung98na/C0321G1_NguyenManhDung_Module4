package com.codegym.controller;

import com.codegym.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String showHomePage(){
        return "calculator";
    }
    @PostMapping("/")
    public String calculate(@RequestParam float soHang1, float soHang2, String btn, Model model){
        float result;
        try {
            result = calculatorService.calculator(soHang1, soHang2, btn);
            model.addAttribute("result", result);
        }catch (Exception e){
            model.addAttribute("result", e.getMessage());
        }
        return "calculator";
    }
}
