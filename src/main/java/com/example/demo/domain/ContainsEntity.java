package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contains")
@IdClass(ContainsEntity.ContainsId.class)
public class ContainsEntity {

    @Id
    @Column(name = "basketid", nullable = false)
    private String basketId;

    @Id
    @Column(name = "isbn", nullable = false)
    private Long isbn;

    @Column(name = "num")
    private Integer num;

    public static class ContainsId implements Serializable {
        private String basketId;
        private Long isbn;

        // Default constructor
        public ContainsId() {}

        // Getters and Setters
        public String getBasketId() {
            return basketId;
        }

        public void setBasketId(String basketId) {
            this.basketId = basketId;
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
            int result = basketId != null ? basketId.hashCode() : 0;
            result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ContainsId that = (ContainsId) o;

            if (basketId != null ? !basketId.equals(that.basketId) : that.basketId != null) return false;
            return isbn != null ? isbn.equals(that.isbn) : that.isbn == null;
        }
    }

    // Getters and Setters
    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}