package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.blog.BlogService;
import com.codegym.model.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 4, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Blog> list = blogService.findAll(pageable);
        return new ModelAndView("blog/list", "blogs", list);
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        LocalDate dateCreate = LocalDate.now();
        blog.setDateCreate(dateCreate.toString());
        Blog blogAdded = blogService.save(blog);
        if (blogAdded != null) {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thất bại!");
        }
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        return new ModelAndView("blog/view", "blog", blog);
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        Blog blogAdded = blogService.save(blog);
        if (blogAdded != null) {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thành công!");
        } else {
            redirectAttributes.addFlashAttribute("status", "Tạo mới thất bại!");
        }
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id-delete") int id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("status", "Xoá thành công!");
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public ModelAndView searchByTitle(@RequestParam("search-content") String titleSearch,
                                      @PageableDefault(value = 4, sort = "dateCreate", direction = Sort.Direction.DESC) Pageable pageable) {
        System.out.println(titleSearch);
        Page<Blog> list = blogService.findByTitle(titleSearch, pageable);
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogs", list);
        modelAndView.addObject("searchContent", titleSearch);
        return modelAndView;
    }
}
