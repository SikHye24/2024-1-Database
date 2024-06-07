package com.example.demo.controller;

import com.example.demo.domain.BookEntity;
import com.example.demo.domain.PublishedByEntity;
import com.example.demo.domain.PublisherEntity;
import com.example.demo.domain.StockEntity;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublishedByRepository;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private PublishedByRepository publishedByRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StockRepository stockRepository;

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

    @GetMapping("/publisher_books")
    public String getBooksByPublisher(@RequestParam("name") String name, Model model) {
        List<PublishedByEntity> publishedByEntities = publishedByRepository.findByName(name);
        List<Long> isbns = publishedByEntities.stream().map(PublishedByEntity::getIsbn).collect(Collectors.toList());

        List<BookEntity> books = bookRepository.findByIsbnIn(isbns);
        List<StockEntity> stocks = stockRepository.findByIsbnIn(isbns);

        model.addAttribute("publisherName", name);
        model.addAttribute("books", books);
        model.addAttribute("stocks", stocks);

        return "publisher_books";
    }

}