package com.codegym.controller;

import com.codegym.model.bean.Product;
import com.codegym.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ModelAndView showList() {
        Map<Integer, Product> list = productService.getAll();
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
            redirectAttributes.addFlashAttribute("success", "Thêm mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("success", "Thêm mới thất bại! Trùng ID");
        }
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public String showView(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.getById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "view";
        } else {
            redirectAttributes.addFlashAttribute("success", "Xem chi tiết thất bại!");
            return "redirect:/product";
        }
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
            redirectAttributes.addFlashAttribute("success", "Cập nhật thành công!");
        } else {
            redirectAttributes.addFlashAttribute("success", "Cập nhật thất bại! Kiểm tra dữ liệu đầu vào");
        }
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id-delete") int id, RedirectAttributes redirectAttributes){
        boolean isSuccess = productService.delete(id);
        if (isSuccess){
            redirectAttributes.addFlashAttribute("success", "Xoá thành công!");
        }else {
            redirectAttributes.addFlashAttribute("success", "Xoá thất bại!");
        }
        return "redirect:/product";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("search-content") String name, Model model){
        Map<Integer, Product> map = productService.searchByName(name);
        if (map.size() == 0){
            model.addAttribute("success", "Không có kết quả thảo mãn!");
        }else {
            model.addAttribute("products", map);
        }
        return "list";
    }
}
