package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

public class PublishedById implements Serializable {

    private String name;
    private Long isbn;

    // Default constructor
    public PublishedById() {}

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

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishedById that = (PublishedById) o;
        return Objects.equals(name, that.name) && Objects.equals(isbn, that.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isbn);
    }
}