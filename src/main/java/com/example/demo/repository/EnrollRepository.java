package com.example.demo.repository;

import com.example.demo.domain.EnrollEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollRepository extends JpaRepository<EnrollEntity, Long> {
    List<EnrollEntity> findBySno(Long sno);
    EnrollEntity findBySnoAndCno(Long sno, String cno);
}