package com.example.demo.controller;

import com.example.demo.domain.ShoppingBasketEntity;
import com.example.demo.repository.ShoppingBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShoppingBasketController {

    @Autowired
    private ShoppingBasketRepository shoppingBasketRepository;

    @GetMapping("/shopping_baskets")
    public String getAllShoppingBaskets(Model model) {
        List<ShoppingBasketEntity> shoppingBaskets = shoppingBasketRepository.findAll();
        model.addAttribute("shoppingBaskets", shoppingBaskets);
        return "shopping_baskets";
    }

    @PostMapping("/shopping_baskets")
    public String addShoppingBasket(@RequestParam String basketid) {
        ShoppingBasketEntity shoppingBasket = new ShoppingBasketEntity();
        shoppingBasket.setBasketid(basketid);
        shoppingBasketRepository.save(shoppingBasket);
        return "redirect:/shopping_baskets";
    }
}