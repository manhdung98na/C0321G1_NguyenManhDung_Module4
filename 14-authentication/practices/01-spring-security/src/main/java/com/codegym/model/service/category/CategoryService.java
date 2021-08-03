package com.codegym.model.service.category;

import com.codegym.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(int id);

    public Category save(Category category);

    public Category delete(int id);

    Page<Category> findByName(String name, Pageable pageable);
}
