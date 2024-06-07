package com.example.demo.controller;

import com.example.demo.domain.BookEntity;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<BookEntity> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/books")
    public String addBook(@RequestParam Long isbn, @RequestParam String title, @RequestParam(required = false) Integer year, @RequestParam(required = false) Integer price) {
        BookEntity book = new BookEntity();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setYear(year);
        book.setPrice(price);
        bookRepository.save(book);
        return "redirect:/books";
    }
}