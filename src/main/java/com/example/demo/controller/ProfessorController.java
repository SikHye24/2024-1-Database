package com.example.demo.controller;

import com.example.demo.domain.ProfessorEntity;
import com.example.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professors")
    public String getProfessors(Model model) {
        List<ProfessorEntity> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        model.addAttribute("professorCount", professors.size());
        return "professors";
    }
}