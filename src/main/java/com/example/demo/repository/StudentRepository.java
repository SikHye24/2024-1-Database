package com.example.demo.repository;

import com.example.demo.domain.EnrollEntity;
import com.example.demo.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT e FROM EnrollEntity e JOIN FETCH e.student s JOIN FETCH e.course c WHERE s.sno = :studentId")
    List<EnrollEntity> findEnrollsByStudentId(Long studentId);
}