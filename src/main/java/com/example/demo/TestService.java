package com.example.demo;

import com.example.demo.domain.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    public List<TestEntity> findAll() {
        List<TestEntity> tracking = testRepository.findAll();
        System.out.println(tracking);
        return tracking;
    }
    public TestEntity save(TestEntity testEntity) {
        testRepository.save(testEntity);
        return testEntity;
    }
    public TestEntity findById(int id) {
        Optional<TestEntity> testEntity = testRepository.findById(id);
        return testEntity.orElse(null);
    }
}
