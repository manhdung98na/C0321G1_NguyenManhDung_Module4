package com.codegym.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {
    private Map<ProductDTO, Integer> products = new HashMap<>();

    public CartDTO() {
    }

    public CartDTO(Map<ProductDTO, Integer> products) {
        this.products = products;
    }

    public Map<ProductDTO, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(ProductDTO product) {
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<ProductDTO, Integer> selectItemInCart(ProductDTO product) {
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(ProductDTO product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<ProductDTO, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void removeProduct(Integer id) {
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (entry.getKey().getId().equals(id)) {
                if (entry.getValue() > 1) {
                    Integer newQuantity = entry.getValue() - 1;
                    products.replace(entry.getKey(), newQuantity);
                }else {
                    products.remove(entry.getKey());
                }
                return;
            }
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Double countTotalPayment() {
        double payment = 0;
        for (Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (double) entry.getValue();
        }
        return payment;
    }
}
