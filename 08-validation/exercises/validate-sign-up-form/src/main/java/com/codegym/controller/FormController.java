package com.codegym.controller;

import com.codegym.dto.UserDTO;
import com.codegym.model.entity.User;
import com.codegym.model.service.UserService;
import org.springframework.beans.BeanUtils;
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
        model.addAttribute("userDTO", new UserDTO());
        return "index";
    }

    @PostMapping("/create")
    public String checkValidation(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDTO().validate(userDTO,bindingResult);
        if (!bindingResult.hasFieldErrors()) {
            User inputUser = new User();
            BeanUtils.copyProperties(userDTO, inputUser);
            User userSaved = service.save(inputUser);
            if(userSaved != null) {
                redirectAttributes.addFlashAttribute("user", new UserDTO());
                redirectAttributes.addFlashAttribute("status", "Thành công!");
                return "redirect:/";
            }
        }
        return "index";
    }
}
