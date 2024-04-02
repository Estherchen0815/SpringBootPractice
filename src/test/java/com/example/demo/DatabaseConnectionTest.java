package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;


//    @Test
//    public void testDatabaseConnection() throws SQLException {
//        assertNotNull(jdbcTemplate.getDataSource().getConnection());
//    }


    @Test
    public void testDatabaseQuery() {
        List<String> result = jdbcTemplate.query("SELECT product_name FROM Product ", (rs, rowNum) -> rs.getString("product_name"));

        System.out.println("Query result:");
        for (String productName : result) {
            System.out.println(productName);
        }
    }
}
