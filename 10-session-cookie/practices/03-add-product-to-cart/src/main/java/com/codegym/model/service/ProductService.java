package com.codegym.model.service;

import com.codegym.model.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
