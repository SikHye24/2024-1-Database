package com.example.demo.controller;

import com.example.demo.domain.CourseEntity;
import com.example.demo.domain.EnrollEntity;
import com.example.demo.domain.StudentEntity;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<StudentEntity> students = studentRepository.findAll();
        model.addAttribute("students", students);
        model.addAttribute("studentCount", students.size());
        return "students";
    }

    @GetMapping("/student/courses")
    public String getCoursesByStudentId(@RequestParam("sno") Long studentId, Model model) {
        List<EnrollEntity> enrolls = studentService.getEnrollsByStudentId(studentId);
        model.addAttribute("enrolls", enrolls);
        return "studentCourses";
    }
    @GetMapping("/student/grades/incorrect")
    public String getIncorrectGrades(Model model) {
        List<EnrollEntity> incorrectGrades = studentService.getIncorrectGrades();
        model.addAttribute("incorrectGrades", incorrectGrades);
        return "incorrectGrades";
    }

    @PostMapping("/student/grades/update")
    public String updateGrade(@RequestParam("sno") Long sno, @RequestParam("cno") String cno, @RequestParam("correctGrade") String correctGrade) {
        studentService.updateGrade(sno, cno, correctGrade);
        return "redirect:/student/grades/incorrect";
    }

    @GetMapping("/scores")
    public String getScores(Model model) {
        Map<String, EnrollEntity> highestScorers = studentService.getHighestScorers();
        Map<String, EnrollEntity> lowestScorers = studentService.getLowestScorers();

        model.addAttribute("highestScorers", highestScorers);
        model.addAttribute("lowestScorers", lowestScorers);

        return "scores";
    }

    @GetMapping("/students/statistics")
    public String getStudentStatistics(Model model) {
        List<StudentEntity> students = studentService.getAllStudents();
        Map<Long, StudentService.StudentStatistics> statistics = studentService.getStudentStatistics();

        model.addAttribute("students", students);
        model.addAttribute("statistics", statistics);

        return "studentStatistics";
    }

    @GetMapping("/courses/statistics")
    public String getCourseStatistics(Model model) {
        Map<String, StudentService.CourseStatistics> courseStatistics = studentService.getCourseStatistics();
        List<CourseEntity> courses = courseRepository.findAll();
        Map<String, String> courseNames = courses.stream()
                .collect(Collectors.toMap(CourseEntity::getCno, CourseEntity::getCname));

        model.addAttribute("courseStatistics", courseStatistics);
        model.addAttribute("courseNames", courseNames);

        return "courseStatistics";
    }

    //학과별, 학년별 학생 수
    @GetMapping("/students/countByDeptAndYear")
    public String getStudentCountByDeptAndYear(Model model) {
        Map<String, Long> studentCountByDept = studentService.getStudentCountByDept();
        Map<Integer, Long> studentCountByYear = studentService.getStudentCountByYear();
        Map<String, Map<Integer, Long>> studentCountByDeptAndYear = studentService.getStudentCountByDeptAndYear();

        model.addAttribute("studentCountByDept", studentCountByDept);
        model.addAttribute("studentCountByYear", studentCountByYear);
        model.addAttribute("studentCountByDeptAndYear", studentCountByDeptAndYear);

        return "studentCountByDeptAndYear";
    }
}