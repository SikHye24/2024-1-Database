package com.example.demo.repository;

import com.example.demo.domain.WrittenByEntity;
import com.example.demo.domain.WrittenById;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WrittenByRepository extends JpaRepository<WrittenByEntity, WrittenById> {
    List<WrittenByEntity> findByNameAndAddress(String name, String address);
}