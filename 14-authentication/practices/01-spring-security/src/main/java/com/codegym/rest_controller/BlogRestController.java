package com.codegym.rest_controller;

import com.codegym.model.entity.Blog;
import com.codegym.model.service.blog.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/blog")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public ResponseEntity<Page<Blog>> findAll(@PageableDefault(value = 4) Pageable pageable) {
        Page<Blog> list = blogService.findAll(pageable);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@RequestParam String title, @PageableDefault(value = 4) Pageable pageable) {
        return new ResponseEntity<>(blogService.findByTitle(title, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Blog blog) {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Blog blog) {
        Optional<Blog> blogFoundById = Optional.ofNullable(blogService.findById(blog.getId()));
        if (!blogFoundById.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
