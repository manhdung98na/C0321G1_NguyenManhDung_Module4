package com.codegym.controller;

import com.codegym.dto.BookDTO;
import com.codegym.exception.BookException;
import com.codegym.model.entity.Book;
import com.codegym.model.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Book> books = service.findAll(pageable);
        return new ModelAndView("index", "books", books);
    }

    @GetMapping("/{id}")
    public ModelAndView showInfo(@PathVariable String id) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(service.findById(id), bookDTO);
        return new ModelAndView("info", "bookDTO", bookDTO);
    }

    @PostMapping("/rent")
    public String rentBook(@ModelAttribute BookDTO bookDTO, RedirectAttributes redirectAttributes) throws BookException {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        service.rentBook(book);
        redirectAttributes.addFlashAttribute("status", "Thuê thành công!");
        return "redirect:/";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String id, RedirectAttributes redirectAttributes) throws BookException {
        service.returnBook(id);
        redirectAttributes.addFlashAttribute("status", "Trả sách thành công");
        return "redirect:/";
    }

    @ExceptionHandler({BookException.class})
    public ModelAndView showBookException(){
        ModelAndView modelAndView =  new ModelAndView("error");
        modelAndView.addObject("status", "Số lượng sách đã hết hoặc Mã sách sai!");
        return modelAndView;
    }
}
