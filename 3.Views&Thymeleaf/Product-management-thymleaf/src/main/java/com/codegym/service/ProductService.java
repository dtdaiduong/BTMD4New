package com.codegym.service;

import com.codegym.model.Product;

import java.util.*;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "bánh", 12000, 15));
        products.put(2, new Product(2, "kẹo", 12000, 15));
        products.put(3, new Product(3, "sữa", 12000, 15));
        products.put(4, new Product(4, "phomai", 12000, 15));
        products.put(5, new Product(5, "oisi", 12000, 15));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name){
        List<Product> productList = new ArrayList<>(products.values());
        List<Product> searchList = new ArrayList<>();
        name = name.toLowerCase(Locale.ROOT);
        for (Product product : productList){
            if (product.getName().toLowerCase().contains(name)){
                searchList.add(product);
            }
        }
        return searchList;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
