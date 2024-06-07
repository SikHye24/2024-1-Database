package com.example.demo.controller;

import com.example.demo.domain.AuthorEntity;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/authors")
    public String getAllAuthors(Model model) {
        List<AuthorEntity> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @PostMapping("/authors")
    public String addAuthor(@RequestParam String name, @RequestParam String address, @RequestParam String url) {
        AuthorEntity author = new AuthorEntity();
        author.setName(name);
        author.setAddress(address);
        author.setUrl(url);
        authorRepository.save(author);
        return "redirect:/authors";
    }
}