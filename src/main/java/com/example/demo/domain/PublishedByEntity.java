package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "published_by")
@IdClass(PublishedById.class)
public class PublishedByEntity {

    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "isbn")
    private Long isbn;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}