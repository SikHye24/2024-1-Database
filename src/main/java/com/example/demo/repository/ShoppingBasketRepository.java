package com.example.demo.repository;

import com.example.demo.domain.ShoppingBasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasketEntity, String> {
}