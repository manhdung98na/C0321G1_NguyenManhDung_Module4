package com.codegym.model.service;

import com.codegym.model.bean.Blog;

import java.util.List;

public interface BlogService {
    public List<Blog> findAll();

    public Blog findById(int id);

    public Blog save(Blog blog);

    public void delete(int id);
}
