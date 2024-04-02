package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Product> getWithinPrice (Integer min, Integer max){
        String sql ="SELECT * FROM PRODUCT WHERE  SELLING_PRICE  BETWEEN :min AND :max";
        Map<String, Object>  map =  new HashMap<String, Object>();
        map.put("min", min);
        map.put("max", max);
        List<Product> result = namedParameterJdbcTemplate.query(sql, map, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                Product product = new Product();
                product.setOid(rs.getLong(1));
                product.setProductNumber(rs.getString(2));
                product.setProductName(rs.getString("product_name"));
                product.setListPrice(rs.getInt(4));
                product.setDiscount(rs.getInt(5));
                product.setSellingPrice(rs.getInt(6));
                product.setLunchDate(rs.getDate(7).toLocalDate());
                product.setStockLevel(rs.getInt(8));
                return product;
            }
        });
       if (result != null){
           return  result;
       }else{
           return null;
       }
    }
}
