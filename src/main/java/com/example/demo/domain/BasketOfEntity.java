package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "basket_of")
public class BasketOfEntity {

    @Id
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "basketid", nullable = false)
    private String basketId;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }
}