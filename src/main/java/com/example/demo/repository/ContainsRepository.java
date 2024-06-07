package com.example.demo.repository;

import com.example.demo.domain.ContainsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainsRepository extends JpaRepository<ContainsEntity, ContainsEntity.ContainsId> {
}