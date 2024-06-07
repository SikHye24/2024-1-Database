package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "written_by")
@IdClass(WrittenById.class)
public class WrittenByEntity {

    @Id
    private String name;

    @Id
    private String address;

    @Id
    private Long isbn;

    // Default constructor
    public WrittenByEntity() {
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}