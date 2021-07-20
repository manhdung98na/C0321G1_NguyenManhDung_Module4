package com.codegym.model.service;

import com.codegym.model.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> getAll();

    public Product getById(int id);

    public boolean add(Product product);

    public boolean update(Product product);

    public boolean delete(int id);

    public List<Product> searchByName(String name);
}
