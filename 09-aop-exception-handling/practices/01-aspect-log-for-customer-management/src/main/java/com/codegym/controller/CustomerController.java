package com.codegym.controller;

import com.codegym.Logger;
import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Province;
import com.codegym.model.service.CustomerService;
import com.codegym.model.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> allProvinces() {
        return provinceService.findAll();
    }

    @GetMapping
    public ModelAndView showList(Optional<String> s, Pageable pageInfo) {
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        try {
            Page<Customer> customers = s.isPresent() ? search(s, pageInfo) : getPage(pageInfo);
            modelAndView.addObject("keyword", s.orElse(null));
            modelAndView.addObject("customers", customers);
            return modelAndView;
        }catch (Exception e){
            System.out.println("Lỗi phương thức showList");
            return new ModelAndView("customers/error");
        }
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        try {
            ModelAndView modelAndView = new ModelAndView("/customers/info");
            Optional<Customer> customerOptional = customerService.findOne(id);
            modelAndView.addObject("customer", customerOptional.get());
            return modelAndView;
        } catch (Exception e) {
            System.out.println("Lỗi phương thức showInformation");
            return new ModelAndView("customers/error");
        }
    }

    @PostMapping
    public ModelAndView updateCustomer(Customer customer) {
        customerService.save(customer);
        return new ModelAndView("redirect:/customers");
    }

    private Page<Customer> getPage(Pageable pageInfo) throws Exception {
        return customerService.findAll(pageInfo);
    }

    private Page<Customer> search(Optional<String> s, Pageable pageInfo) {
        return customerService.search(s.get(), pageInfo);
    }
}