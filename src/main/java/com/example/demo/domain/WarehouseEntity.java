package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouse")
public class WarehouseEntity {

    @Id
    private String code;

    private String address;
    private String phone;

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}