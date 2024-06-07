package com.example.demo.repository;

import com.example.demo.domain.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherEntity, String> {
}