package com.example.demo.controller;

import com.example.demo.domain.PublishedByEntity;
import com.example.demo.repository.PublishedByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PublishedByController {

    @Autowired
    private PublishedByRepository publishedByRepository;

    @GetMapping("/published_by")
    public String getAllPublishedBy(Model model) {
        List<PublishedByEntity> publishedByEntities = publishedByRepository.findAll();
        model.addAttribute("publishedByEntities", publishedByEntities);
        return "published_by";
    }

    @PostMapping("/published_by")
    public String addPublishedBy(@RequestParam String name, @RequestParam Long isbn) {
        PublishedByEntity publishedBy = new PublishedByEntity();
        publishedBy.setName(name);
        publishedBy.setIsbn(isbn);
        publishedByRepository.save(publishedBy);
        return "redirect:/published_by";
    }
}