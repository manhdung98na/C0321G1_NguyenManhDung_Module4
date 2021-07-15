package com.codegym.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showHomePage(){
        return "calculator";
    }
    @PostMapping("/")
    public String calculate(@RequestParam float soHang1, float soHang2, String btn, Model model){
        float result;
        switch (btn){
            case "addition":
                result = soHang1 + soHang2;
                break;
            case "subtraction":
                result = soHang1 - soHang2;
                break;
            case "multiplication":
                result = soHang1 * soHang2;
                break;
            case "division":
                if (soHang2 == 0){
                    model.addAttribute("result", "Can not divide to Zero!");
                    return "calculator";
                }else {
                    result = soHang1 / soHang2;
                }
                break;
            default:
                return "calculator";
        }
        model.addAttribute("result", result);
        return "calculator";
    }
}
