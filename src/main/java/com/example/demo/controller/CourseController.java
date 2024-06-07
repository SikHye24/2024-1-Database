package com.example.demo.controller;

import com.example.demo.domain.CourseEntity;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String getCourses(Model model) {
        List<CourseEntity> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("courseCount", courses.size());
        return "courses";
    }
}