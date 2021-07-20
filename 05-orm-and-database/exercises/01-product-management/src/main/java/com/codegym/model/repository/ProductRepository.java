package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductRepository {
    public List<Product> getAll();

    public Product getById(int id);

    public void add(Product product);

    public boolean update(Product product);

    public Product delete(int id);

    public List<Product> searchByName(String name);
}
