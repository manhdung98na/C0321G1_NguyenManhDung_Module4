package com.codegym.model.service.category;

import com.codegym.model.bean.Category;
import com.codegym.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(int id) {
        Category category = findById(id);
        if (category != null) {
            categoryRepository.deleteById(id);
        }
        return category;
    }

    @Override
    public Page<Category> findByName(String name, Pageable pageable) {
        return categoryRepository.findByNameCategoryContaining(name, pageable);
    }
}
