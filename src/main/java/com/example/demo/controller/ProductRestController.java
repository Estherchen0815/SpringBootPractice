package com.example.demo.controller;


import com.example.demo.service.ProductServiceImpl;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductServiceImpl productService;



    @GetMapping("/product/findAll")
    @ResponseBody
    public List<Product> findAllProduct(){
        return productService.findAll();
    }


    @GetMapping("/product/findByNumber")
    @ResponseBody
    public ResponseEntity<Product> findProductByProductNumber(@RequestParam(name="productNumber") String number){
        Product product = productService.findByNumber(number);
        /**
         * springBoot 提供 ResponseEntity讓其回傳不再只是回傳payLoad
         * 透過status方法可傳入狀態 OK (200) NOT FOUND(400)
         * 若OK 呼叫body即可傳入原本要傳入的payLoad
         * 但要注意controller回傳要是ResponseEntity<T>
         */
        return product == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @PostMapping ("/product/addProduct")
    @ResponseBody
    public List<Product> addOneProduct(@RequestBody Product product){
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        product.setLunchDate(localDate);
        productService.addOneProduct(product);
        return productService.findAll();
    }
    @DeleteMapping("/product/deleteProduct")
    @ResponseBody
    public List<Product> deleteProductByProductNumber(@RequestParam(name="productNumber") String number){
        Product productToD = productService.findByNumber(number);
        Long oid = productToD.getOid();
        productService.deleteProductByOid(oid);
        return productService.findAll();
    }

    @PutMapping ("/product/updateProduct")
    @ResponseBody
    public List<Product> updateProductByProductNumber(@RequestParam(name="productNumber") String number, @RequestParam(name="sellPrice") Integer price){
        Integer integer = productService.updateProductByNumber(number, price);
        if(integer > 0){
            return productService.findAll();
        }else{
            return null;
        }
    }
    @RequestMapping("/product/jdbc/findProduct")
    @ResponseBody
    public List<Product>findWithinPrice(@RequestParam(name="min") Integer min, @RequestParam(name="max") Integer max) {
        List<Product> withinPriceByJDBC = productService.findWithinPriceByJDBC(min, max);
        return withinPriceByJDBC;
    }

}

