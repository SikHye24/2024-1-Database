package com.example.demo.repository;

import com.example.demo.domain.PublishedByEntity;
import com.example.demo.domain.PublishedById;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublishedByRepository extends JpaRepository<PublishedByEntity, PublishedById> {
    List<PublishedByEntity> findByName(String name);
}