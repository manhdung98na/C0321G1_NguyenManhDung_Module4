package com.codegym.model.service.category;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(int id);

    public Category save(Category category);

    public void delete(int id);

    Page<Category> findByName(String name, Pageable pageable);
}
