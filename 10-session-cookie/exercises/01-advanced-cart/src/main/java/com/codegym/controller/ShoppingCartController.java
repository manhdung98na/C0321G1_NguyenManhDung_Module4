package com.codegym.controller;

import com.codegym.dto.CartDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public CartDTO setupCart(){
        return new CartDTO();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Optional<CartDTO> cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        if (cart.isPresent()) {
            modelAndView.addObject("cart", cart.get());
        }else {
            modelAndView.addObject("cart", new CartDTO());
        }
        return modelAndView;

    }

}
