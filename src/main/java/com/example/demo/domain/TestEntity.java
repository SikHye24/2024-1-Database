package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
@Entity(name = "test")
@Table(name = "test")
@Getter
@Setter
public class TestEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
}