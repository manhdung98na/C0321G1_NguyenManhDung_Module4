package com.codegym.controller;

import com.codegym.dto.CartDTO;
import com.codegym.dto.ProductDTO;
import com.codegym.model.entity.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public CartDTO setupCart() {
        return new CartDTO();
    }
    @RequestMapping("/")
    public String redirectToShop(){
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public ModelAndView showShop(@PageableDefault(value = 4)Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/shop");
        Page<Product> products = productService.findAll(pageable);
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping("/shop/add/{id}")
    public String addToCart(@PathVariable Integer id, @SessionAttribute CartDTO cart,
                            @RequestParam("action") Optional<String> action, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (!action.isPresent()) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productOptional.get(),productDTO);
            cart.addProduct(productDTO);
            redirectAttributes.addFlashAttribute("status", "Add to cart successfully!");
            return "redirect:/shop";
        }else {
            if (action.get().equals("increase")){
                ProductDTO productDTO = new ProductDTO();
                BeanUtils.copyProperties(productOptional.get(),productDTO);
                cart.addProduct(productDTO);
            }else {
                cart.removeProduct(id);
            }
            return "redirect:/shopping-cart";
        }
    }

    @GetMapping("/shop/info/{id}")
    public String showDetail(@PathVariable Optional<Integer> id, Model model){
        if (!id.isPresent()){
            return "error.404";
        }
        Optional<Product> product = productService.findById(id.get());
        if (!product.isPresent()){
            return "error.404";
        }
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product.get(), productDTO);
        model.addAttribute("productDTO", productDTO);
        return "detail";
    }
}
