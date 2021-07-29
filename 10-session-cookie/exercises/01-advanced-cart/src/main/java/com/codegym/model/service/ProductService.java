package com.codegym.model.service;

import com.codegym.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Integer id);
}
