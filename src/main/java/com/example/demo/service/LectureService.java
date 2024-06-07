package com.example.demo.service;

import com.example.demo.domain.LectureEntity;
import com.example.demo.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    public Map<String, Long> getLectureCountByDept() {
        List<LectureEntity> lectures = lectureRepository.findAll();

        return lectures.stream()
                .collect(Collectors.groupingBy(
                        lecture -> lecture.getProfessor().getPdept(), // Assuming getProfessor() returns the related professor entity
                        Collectors.counting()
                ));
    }
}