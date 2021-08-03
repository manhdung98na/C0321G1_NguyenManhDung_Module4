package com.codegym.controller;

import com.codegym.model.entity.Category;
import com.codegym.model.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView showCategory() {
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showListOfBlog(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("category/view");
        Category category = categoryService.findById(id);
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String addCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        Category categoryAdded = categoryService.save(category);
        if (categoryAdded != null) {
            redirectAttributes.addFlashAttribute("status", "Thêm mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Thêm mới thất bại!");
        }
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", categoryService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        Category categoryEdited = categoryService.save(category);
        if (categoryEdited != null) {
            redirectAttributes.addFlashAttribute("status", "Update thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Update thất bại!");
        }
        return "redirect:/category";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("id-delete") int id, RedirectAttributes redirectAttributes) {
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("status", "Xoá thành công!");
        return "redirect:/category";
    }
    @GetMapping("/search")
    public ModelAndView searchByTitle(@RequestParam("search-content") String name,
                                      @PageableDefault(value = 5, sort = "id") Pageable pageable) {
        Page<Category> list = categoryService.findByName(name, pageable);
        return new ModelAndView("category/list", "categories", list);
    }
}
