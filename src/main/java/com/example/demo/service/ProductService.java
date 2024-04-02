package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;


public interface ProductService {

    List<Product> findAll();

    Boolean addOneProduct(Product product);

    void deleteProductByOid(Long oid);

    Product findByNumber (String number);

    Integer updateProductByNumber(String productNumber, Integer price);

    List<Product> findWithinPriceByJDBC(Integer min, Integer max);
}
