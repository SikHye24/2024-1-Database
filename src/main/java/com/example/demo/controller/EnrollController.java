package com.example.demo.controller;

import com.example.demo.domain.EnrollEntity;
import com.example.demo.domain.CourseEntity;
import com.example.demo.repository.EnrollRepository;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EnrollController {

    @Autowired
    private EnrollRepository enrollRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/enrolls")
    public String getAllEnrolls(Model model) {
        List<EnrollEntity> enrolls = enrollRepository.findAll();
        model.addAttribute("enrolls", enrolls);
        return "enrolls";
    }

    @GetMapping("/enrolls/student")
    public String getEnrollsByStudent(@RequestParam("sno") Long sno, Model model) {
        List<EnrollEntity> enrolls = enrollRepository.findBySno(sno);
        model.addAttribute("enrolls", enrolls);

        List<CourseEntity> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);

        return "fragments/studentEnrollFragment";
    }
}