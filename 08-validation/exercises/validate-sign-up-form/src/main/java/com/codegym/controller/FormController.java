package com.codegym.controller;

import com.codegym.model.bean.User;
import com.codegym.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FormController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/create")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasFieldErrors()) {
            User userSaved = service.save(user);
            if(userSaved != null) {
                redirectAttributes.addFlashAttribute("user", new User());
                redirectAttributes.addFlashAttribute("status", "Thành công!");
                return "redirect:/";
            }
        }
        return "index";
    }
}
