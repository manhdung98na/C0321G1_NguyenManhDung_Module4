package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.bean.Customer;
import cg.wbd.grandemonstration.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList() {
        List<Customer> customers = customerService.findAll();
        return new ModelAndView("customers/list", "customers", customers);
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/add";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer){
        customerService.add(customer);
        return "redirect:/customers";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id-delete") long id){
        customerService.delete(id);
        return "redirect:/customers";
    }
}
