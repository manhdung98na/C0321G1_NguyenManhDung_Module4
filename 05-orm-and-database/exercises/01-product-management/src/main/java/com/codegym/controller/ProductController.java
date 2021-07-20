package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView showList() {
        List<Product> list = productService.getAll();
        return new ModelAndView("list", "products", list);
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/create")
    public String createProduct(Product product, RedirectAttributes redirectAttributes) {
        boolean isSuccess = productService.add(product);
        if (isSuccess) {
            redirectAttributes.addFlashAttribute("status", "Thêm mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Thêm mới thất bại! Trùng ID");
        }
        return "redirect:/products";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(Product product, RedirectAttributes redirectAttributes) {
        boolean isSuccess = productService.update(product);
        if (isSuccess) {
            redirectAttributes.addFlashAttribute("status", "Cập nhật thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Cập nhật thất bại! Kiểm tra dữ liệu đầu vào");
        }
        return "redirect:/products";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id-delete") int id, RedirectAttributes redirectAttributes){
        boolean isSuccess = productService.delete(id);
        if (isSuccess){
            redirectAttributes.addFlashAttribute("status", "Xoá thành công!");
        }else {
            redirectAttributes.addFlashAttribute("status", "Xoá thất bại!");
        }
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("search-content") String name, Model model){
        List<Product> list = productService.searchByName(name);
        System.out.println(list.size());
        if (list.size() == 0){
            model.addAttribute("status", "Không có kết quả thảo mãn!");
        }else {
            model.addAttribute("products", list);
        }
        return "list";
    }
}
