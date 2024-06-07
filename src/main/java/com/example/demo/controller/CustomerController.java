package com.example.demo.controller;

import com.example.demo.domain.CustomerEntity;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<CustomerEntity> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @PostMapping("/customers")
    public String addCustomer(@RequestParam String email, @RequestParam String name, @RequestParam String address, @RequestParam String phone) {
        CustomerEntity customer = new CustomerEntity();
        customer.setEmail(email);
        customer.setName(name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customerRepository.save(customer);
        return "redirect:/customers";
    }
}