package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_basket")
public class ShoppingBasketEntity {

    @Id
    private String basketid;

    // Getters and Setters
    public String getBasketid() {
        return basketid;
    }

    public void setBasketid(String basketid) {
        this.basketid = basketid;
    }
}