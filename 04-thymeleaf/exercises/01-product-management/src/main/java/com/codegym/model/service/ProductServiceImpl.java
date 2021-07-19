package com.codegym.model.service;

import com.codegym.model.bean.Product;
import com.codegym.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public Map<Integer, Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public boolean add(Product product) {
        int id = product.getId();
        Map<Integer, Product> list = repository.getAll();
        for (Integer key: list.keySet()){
            if (id == key){
                return false;
            }
        }
        repository.save(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        int id = product.getId();
        Map<Integer, Product> list = repository.getAll();
        if (!list.containsKey(id)){
            return false;
        }
        repository.save(product);
        return true;
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != null;
    }

    @Override
    public Product showDetail(int id) {
        return repository.showDetail(id);
    }

    @Override
    public Map<Integer, Product> searchByName(String name) {
        return repository.searchByName(name);
    }
}
