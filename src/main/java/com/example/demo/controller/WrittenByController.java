package com.example.demo.controller;

import com.example.demo.domain.BookEntity;
import com.example.demo.domain.StockEntity;
import com.example.demo.domain.WrittenByEntity;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.WrittenByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WrittenByController {

    @Autowired
    private WrittenByRepository writtenByRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/written_by")
    public String getAllWrittenBy(Model model) {
        List<WrittenByEntity> writtenBy = writtenByRepository.findAll();
        model.addAttribute("writtenBy", writtenBy);
        return "written_by";
    }

    @PostMapping("/written_by")
    public String addWrittenBy(@RequestParam String name, @RequestParam String address, @RequestParam Long isbn) {
        WrittenByEntity writtenByEntity = new WrittenByEntity();
        writtenByEntity.setName(name);
        writtenByEntity.setAddress(address);
        writtenByEntity.setIsbn(isbn);
        writtenByRepository.save(writtenByEntity);
        return "redirect:/written_by";
    }

    @GetMapping("/author_books")
    public String getBooksByAuthor(@RequestParam("name") String name, @RequestParam("address") String address, Model model) {
        List<WrittenByEntity> writtenByEntities = writtenByRepository.findByNameAndAddress(name, address);
        List<Long> isbns = writtenByEntities.stream().map(WrittenByEntity::getIsbn).collect(Collectors.toList());

        List<BookEntity> books = bookRepository.findByIsbnIn(isbns);
        List<StockEntity> stocks = stockRepository.findByIsbnIn(isbns);

        model.addAttribute("authorName", name);
        model.addAttribute("authorAddress", address);
        model.addAttribute("books", books);
        model.addAttribute("stocks", stocks);

        return "author_books";
    }
}