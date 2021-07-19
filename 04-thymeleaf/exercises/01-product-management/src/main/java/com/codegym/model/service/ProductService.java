package com.codegym.model.service;

import com.codegym.model.bean.Product;

import java.util.Map;

public interface ProductService {
    public Map<Integer, Product> getAll();

    public Product getById(int id);

    public boolean add(Product product);

    public boolean update(Product product);

    public boolean delete(int id);

    public Product showDetail(int id);

    public Map<Integer, Product> searchByName(String name);
}
