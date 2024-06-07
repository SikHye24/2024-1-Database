package com.example.demo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stocks")
@IdClass(StockEntity.StockId.class)
public class StockEntity {

    @Id
    private Long isbn;

    @Id
    private String code;

    private Integer num;

    // Getters and Setters
    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    // Embedded IdClass
    public static class StockId implements Serializable {
        private Long isbn;
        private String code;

        // Getters and Setters
        public Long getIsbn() {
            return isbn;
        }

        public void setIsbn(Long isbn) {
            this.isbn = isbn;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        // hashCode and equals
        @Override
        public int hashCode() {
            return isbn.hashCode() + code.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            StockId stockId = (StockId) obj;
            return isbn.equals(stockId.isbn) && code.equals(stockId.code);
        }
    }
}