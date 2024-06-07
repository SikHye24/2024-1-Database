package com.example.demo.controller;

import com.example.demo.domain.ContainsEntity;
import com.example.demo.repository.ContainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContainsController {

    @Autowired
    private ContainsRepository containsRepository;

    @GetMapping("/contains")
    public String getAllContains(Model model) {
        List<ContainsEntity> contains = containsRepository.findAll();
        model.addAttribute("contains", contains);
        return "contains";
    }

    @PostMapping("/contains")
    public String addContains(@RequestParam String basketId, @RequestParam Long isbn, @RequestParam Integer num) {
        ContainsEntity contains = new ContainsEntity();
        contains.setBasketId(basketId);
        contains.setIsbn(isbn);
        contains.setNum(num);
        containsRepository.save(contains);
        return "redirect:/contains";
    }
}