package com.example.backendb.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "fullName")
    private String fullName;

    @Temporal(TemporalType.DATE)
//    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    private int phonenumber;

    public Customer() {}
//
//    public Customer(String fullName, Date dateOfBirth) {
//        this.fullName = fullName;
//        this.dateOfBirth = dateOfBirth;
//        this.phonenumber= phonenumber;
//    }

    // getters and setters for id, fullName, and dateOfBirth

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }
}

