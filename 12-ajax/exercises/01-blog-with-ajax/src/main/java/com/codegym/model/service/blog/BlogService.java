package com.codegym.model.service.blog;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    public List<Blog> findAll();

    public Page<Blog> findAll(Pageable pageable);

    public Blog findById(int id);

    public Page<Blog> findByTitle(String title, Pageable pageable);

    public List<Blog> findByTitle(String title);

    public Blog save(Blog blog);

    public void delete(int id);
}
