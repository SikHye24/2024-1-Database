package com.example.demo.repository;

import com.example.demo.domain.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, StockEntity.StockId> {
    List<StockEntity> findByIsbnIn(List<Long> isbns);
}