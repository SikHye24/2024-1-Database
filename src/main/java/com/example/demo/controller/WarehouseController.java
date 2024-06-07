package com.example.demo.controller;

import com.example.demo.domain.WarehouseEntity;
import com.example.demo.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WarehouseController {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @GetMapping("/warehouses")
    public String getAllWarehouses(Model model) {
        List<WarehouseEntity> warehouses = warehouseRepository.findAll();
        model.addAttribute("warehouses", warehouses);
        return "warehouses";
    }

    @PostMapping("/warehouses")
    public String addWarehouse(@RequestParam String code, @RequestParam String address, @RequestParam String phone) {
        WarehouseEntity warehouse = new WarehouseEntity();
        warehouse.setCode(code);
        warehouse.setAddress(address);
        warehouse.setPhone(phone);
        warehouseRepository.save(warehouse);
        return "redirect:/warehouses";
    }
}