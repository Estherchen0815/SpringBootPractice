package com.example.demo.service;


import com.example.demo.dao.ProductDao;
import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
         return productRepository.findAll();
    }

    @Override
    public Boolean addOneProduct(Product product) {
        Product saved = productRepository.save(product);
         if (saved!=null){
             return true;
         }
        return false;
    }

    @Override
    public void deleteProductByOid(Long oid) {
        productRepository.deleteById(oid);
    }

    @Override
    public Product findByNumber(String number) {
        return productRepository.findByProductNumber(number);
    }

    @Override
    public Integer updateProductByNumber(String productNumber, Integer price) {
        return productRepository.updateProductByProductNumber(productNumber, price);
    }

    @Override
    public List<Product> findWithinPriceByJDBC(Integer min, Integer max) {
        return productDao.getWithinPrice(min, max);
    }


}
