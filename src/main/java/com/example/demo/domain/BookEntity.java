package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @Column(name = "isbn", nullable = false)
    private Long isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "price")
    private Integer price;

    // Getters and Setters
    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}