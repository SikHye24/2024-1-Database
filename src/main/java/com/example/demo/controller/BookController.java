package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.repository.*;
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

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private PublishedByRepository publishedByRepository;

    @Autowired
    private WrittenByRepository writtenByRepository;

    @GetMapping("/new_book")
    public String newBookForm() {
        return "new_book";
    }

    @GetMapping("/statistics")
    public String getStatistics(Model model) {
        Double averagePrice = bookRepository.findAveragePrice();
        List<Object[]> averagePriceByYear = bookRepository.findAveragePriceByYear();

        model.addAttribute("averagePrice", averagePrice);
        model.addAttribute("averagePriceByYear", averagePriceByYear);

        return "statistics";
    }

    @GetMapping("/author_statistics")
    public String getAuthorStatistics(Model model) {
        List<Object[]> authorStatistics = bookRepository.findAuthorStatistics();

        model.addAttribute("authorStatistics", authorStatistics);

        return "author_statistics";
    }

    @GetMapping("/discount")
    public String getDiscountPage() {
        return "discount";
    }

    @PostMapping("/search_books_by_stock")
    public String searchBooksByStock(@RequestParam int stockThreshold, Model model) {
        List<BookEntity> books = bookRepository.findBooksByStockThreshold(stockThreshold);
        model.addAttribute("books", books);
        model.addAttribute("stockThreshold", stockThreshold);
        return "discount";
    }

    @PostMapping("/apply_discount")
    public String applyDiscount(@RequestParam int stockThreshold, @RequestParam double discount, Model model) {
        bookRepository.applyDiscountToBooksByStockThreshold(stockThreshold, 1 - discount / 100.0);
        List<BookEntity> books = bookRepository.findBooksByStockThreshold(stockThreshold);
        model.addAttribute("books", books);
        model.addAttribute("stockThreshold", stockThreshold);
        model.addAttribute("message", "Discount applied successfully!");
        return "discount";
    }

    @PostMapping("/register_book")
    public String registerBook(@RequestParam Long isbn, @RequestParam String title,
                               @RequestParam int year, @RequestParam int price,
                               @RequestParam String authorName, @RequestParam String authorAddress, @RequestParam String authorUrl,
                               @RequestParam String publisherName, @RequestParam String publisherAddress,
                               @RequestParam String publisherPhone, @RequestParam String publisherUrl,
                               @RequestParam String warehouseCode, @RequestParam int stockNum, Model model) {
        // Save book
        BookEntity book = new BookEntity();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setYear(year);
        book.setPrice(price);
        bookRepository.save(book);

        // Save author
        AuthorEntity author = new AuthorEntity();
        author.setName(authorName);
        author.setAddress(authorAddress);
        author.setUrl(authorUrl);
        authorRepository.save(author);

        // Save written by
        WrittenByEntity writtenBy = new WrittenByEntity();
        writtenBy.setName(authorName);
        writtenBy.setAddress(authorAddress);
        writtenBy.setIsbn(isbn);
        writtenByRepository.save(writtenBy);

        // Save publisher
        PublisherEntity publisher = new PublisherEntity();
        publisher.setName(publisherName);
        publisher.setAddress(publisherAddress);
        publisher.setPhone(publisherPhone);
        publisher.setUrl(publisherUrl);
        publisherRepository.save(publisher);

        // Save published by
        PublishedByEntity publishedBy = new PublishedByEntity();
        publishedBy.setName(publisherName);
        publishedBy.setIsbn(isbn);
        publishedByRepository.save(publishedBy);

        // Save stock
        StockEntity stock = new StockEntity();
        stock.setIsbn(isbn);
        stock.setCode(warehouseCode);
        stock.setNum(stockNum);
        stockRepository.save(stock);

        model.addAttribute("message", "Book registered successfully!");
        return "new_book";
    }

}
