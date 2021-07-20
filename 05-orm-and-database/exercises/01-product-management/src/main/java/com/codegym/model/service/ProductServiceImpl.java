package com.codegym.model.service;

import com.codegym.model.bean.Product;
import com.codegym.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public boolean add(Product product) {
        Integer id = product.getId();
        List<Product> list = repository.getAll();
        for (Product key : list) {
            if (id == key.getId()) {
                return false;
            }
        }
        repository.add(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        Integer id = product.getId();
        List<Product> list = repository.getAll();
        for (Product key : list) {
            if (id == key.getId()) {
                return repository.update(product);
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != null;
    }

    @Override
    public List<Product> searchByName(String name) {
        return repository.searchByName(name);
    }
}
