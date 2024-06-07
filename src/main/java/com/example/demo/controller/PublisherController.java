package com.example.demo.controller;

import com.example.demo.domain.PublisherEntity;
import com.example.demo.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping("/publishers")
    public String getAllPublishers(Model model) {
        List<PublisherEntity> publishers = publisherRepository.findAll();
        model.addAttribute("publishers", publishers);
        return "publishers";
    }

    @PostMapping("/publishers")
    public String addPublisher(@RequestParam String name, @RequestParam String address, @RequestParam String phone, @RequestParam String url) {
        PublisherEntity publisher = new PublisherEntity();
        publisher.setName(name);
        publisher.setAddress(address);
        publisher.setPhone(phone);
        publisher.setUrl(url);
        publisherRepository.save(publisher);
        return "redirect:/publishers";
    }
}