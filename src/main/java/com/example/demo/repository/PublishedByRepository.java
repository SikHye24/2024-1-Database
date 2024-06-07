package com.example.demo.repository;

import com.example.demo.domain.PublishedByEntity;
import com.example.demo.domain.PublishedById;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishedByRepository extends JpaRepository<PublishedByEntity, PublishedById> {
}