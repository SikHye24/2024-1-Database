package com.example.demo.controller;

import com.example.demo.domain.BasketOfEntity;
import com.example.demo.repository.BasketOfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BasketOfController {

    @Autowired
    private BasketOfRepository basketOfRepository;

    @GetMapping("/baskets")
    public String getAllBaskets(Model model) {
        List<BasketOfEntity> baskets = basketOfRepository.findAll();
        model.addAttribute("baskets", baskets);
        return "baskets";
    }

    @PostMapping("/baskets")
    public String addBasket(@RequestParam String email, @RequestParam String basketId) {
        BasketOfEntity basket = new BasketOfEntity();
        basket.setEmail(email);
        basket.setBasketId(basketId);
        basketOfRepository.save(basket);
        return "redirect:/baskets";
    }
}