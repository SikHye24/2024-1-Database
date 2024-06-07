package com.example.demo.controller;

import com.example.demo.domain.LectureEntity;
import com.example.demo.repository.LectureRepository;
import com.example.demo.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class LectureController {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private LectureService lectureService; // lectureService 주입

    @GetMapping("/lectures")
    public String getLectures(Model model) {
        List<LectureEntity> lectures = lectureRepository.findAll();
        model.addAttribute("lectures", lectures);
        model.addAttribute("lectureCount", lectures.size());
        return "lectures";
    }

    @GetMapping("/lectures/countByDept")
    public String getLectureCountByDept(Model model) {
        Map<String, Long> lectureCountByDept = lectureService.getLectureCountByDept();

        model.addAttribute("lectureCountByDept", lectureCountByDept);

        return "lectureCountByDept";
    }
}