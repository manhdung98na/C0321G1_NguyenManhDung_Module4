package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
    public final static Map<Integer, Product> list;
    static {
        list = new HashMap<>();
        list.put(1,new Product(1, "Bút bi", "Thiên Long", (float) 5000));
        list.put(2,new Product(2, "Vở kẻ ngang", "Campus", (float) 15000));
        list.put(3,new Product(3, "Bút xoá", "Thiên Long", (float) 10000));
        list.put(4,new Product(4, "Thước kẻ", "Hoa Việt", (float) 8000));
    }

    @Override
    public Map<Integer, Product> getAll() {
        return list;
    }

    @Override
    public Product getById(int id) {
        return list.get(id);
    }

    @Override
    public void save(Product product) {
        list.put(product.getId(), product);
    }

    @Override
    public Product delete(int id) {
        return list.remove(id);
    }

    @Override
    public Product showDetail(int id) {
        return list.get(id);
    }

    @Override
    public Map<Integer, Product> searchByName(String name) {
        Map<Integer, Product> result = new HashMap<>();
        for (Integer key: list.keySet()){
            if (list.get(key).getName().toLowerCase().contains(name.toLowerCase())){
                result.put(list.get(key).getId(), list.get(key));
            }
        }
        return result;
    }
}
