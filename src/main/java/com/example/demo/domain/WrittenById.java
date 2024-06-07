package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

public class WrittenById implements Serializable {
    private String name;
    private String address;
    private Long isbn;

    // Default constructor
    public WrittenById() {
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

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(name, address, isbn);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WrittenById that = (WrittenById) obj;
        return Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(isbn, that.isbn);
    }
}