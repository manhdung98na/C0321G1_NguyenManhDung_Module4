package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.Map;

public interface ProductRepository {
    public Map<Integer, Product> getAll();

    public Product getById(int id);

    public void save(Product product);

    public Product delete(int id);

    public Product showDetail(int id);

    public Map<Integer, Product> searchByName(String name);
}
