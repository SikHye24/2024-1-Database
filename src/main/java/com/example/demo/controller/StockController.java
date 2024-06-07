package com.example.demo.controller;

import com.example.demo.domain.StockEntity;
import com.example.demo.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/stocks")
    public String getAllStocks(Model model) {
        List<StockEntity> stocks = stockRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "stocks";
    }

    @PostMapping("/stocks")
    public String addStock(@RequestParam Long isbn, @RequestParam String code, @RequestParam Integer num) {
        StockEntity stock = new StockEntity();
        stock.setIsbn(isbn);
        stock.setCode(code);
        stock.setNum(num);
        stockRepository.save(stock);
        return "redirect:/stocks";
    }
}