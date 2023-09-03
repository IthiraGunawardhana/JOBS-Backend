package com.example.backendb.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Order_TBL")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productname;

    private String address;
    @Column(name = "totalamount")
    private Double totalAmount;

    public Order(Long id, String productname, String address, Double totalAmount) {
        this.id = id;
        this.productname = productname;
        this.address = address;
        this.totalAmount = totalAmount;
    }

    public Order() {

    }

    public Order(String s, String matara, double v) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean getStatusCode() {

        return false;
    }

    public char getStatusCodeValue() {
        return 200;
    }
}