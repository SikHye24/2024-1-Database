package com.example.demo.repository;

import com.example.demo.domain.BasketOfEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketOfRepository extends JpaRepository<BasketOfEntity, String> {
}