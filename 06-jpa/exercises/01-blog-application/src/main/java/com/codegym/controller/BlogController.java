package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public ModelAndView showList() {
        List<Blog> list = blogService.findAll();
        return new ModelAndView("list", "blogs", list);
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        Blog blogAdded = blogService.save(blog);
        if (blogAdded != null) {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thất bại!");
        }
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("view", "blog", blog);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("edit", "blog", blog);
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        Blog blogAdded = blogService.save(blog);
        if (blogAdded != null) {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thất bại!");
        }
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id-delete") int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("status", "Xoá thành công!");
        return "redirect:/";
    }
}
