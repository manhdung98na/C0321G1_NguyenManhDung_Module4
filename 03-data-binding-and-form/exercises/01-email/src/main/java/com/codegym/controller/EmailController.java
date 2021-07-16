package com.codegym.controller;

import com.codegym.model.EmailSetting;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("setting", "emailSetting", new EmailSetting());
    }

    @PostMapping("/save-setting")
    public ModelAndView saveSetting(@ModelAttribute("emailSetting") EmailSetting emailSetting){
        return new ModelAndView("result");
    }
}
