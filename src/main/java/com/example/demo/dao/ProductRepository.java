package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    @Override
    List<Product> findAll();


//
//    List<Product> findByListPriceBetween(int minListPrice, int maxListPrice);
//
//    List<Product> findByLaunchDateAfterOrderByListPriceDesc(LocalDate startDate);
//
    Product findByProductNumber(String productNumber);
    @Modifying
    @Transactional
    @Query(value = "UPDATE PRODUCT SET SELLING_PRICE =:sellPrice  WHERE PRODUCT_NUMBER = :productNumber",nativeQuery = true)
    public Integer updateProductByProductNumber (@Param(value="productNumber")String number, @Param(value="sellPrice")Integer price);

}
