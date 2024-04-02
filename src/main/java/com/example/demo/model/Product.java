package com.example.demo.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
@Entity(name="product")
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    private Long oid;

    @Column(name = "product_number")
    private String productNumber;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "list_price")
    private int listPrice;

    @Column(name = "discount")
    private double discount;

    @Column(name = "selling_price")
    private int sellingPrice;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "launch_date")
    private LocalDate launchDate;

    @Column(name = "stock_level")
    private int stockLevel;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getListPrice() {
        return listPrice;
    }

    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}
