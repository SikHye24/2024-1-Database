package com.example.demo.repository;

import com.example.demo.domain.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, String> {
}