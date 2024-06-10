package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BasketOfRepository basketOfRepository;

    @Autowired
    private ContainsRepository containsRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublishedByRepository publishedByRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private WrittenByRepository writtenByRepository;

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<CustomerEntity> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/customer_details")
    public String getCustomerDetails(@RequestParam String email, Model model) {
        CustomerEntity customer = customerRepository.findById(email).orElse(null);
        if (customer != null) {
            List<BasketOfEntity> basketOfList = basketOfRepository.findAll()
                    .stream()
                    .filter(basketOf -> basketOf.getEmail().equals(email))
                    .collect(Collectors.toList());

            if (!basketOfList.isEmpty()) {
                String basketId = basketOfList.get(0).getBasketId();

                List<ContainsEntity> containsList = containsRepository.findAll()
                        .stream()
                        .filter(contains -> contains.getBasketId().equals(basketId))
                        .collect(Collectors.toList());

                List<Long> isbns = containsList.stream().map(ContainsEntity::getIsbn).collect(Collectors.toList());
                List<BookEntity> books = bookRepository.findByIsbnIn(isbns);

                Map<Long, PublisherEntity> publishers = publishedByRepository.findAll()
                        .stream()
                        .filter(publishedBy -> isbns.contains(publishedBy.getIsbn()))
                        .collect(Collectors.toMap(PublishedByEntity::getIsbn,
                                publishedBy -> publisherRepository.findById(publishedBy.getName()).orElse(null)));

                List<WrittenByEntity> writtenByEntities = writtenByRepository.findAll()
                        .stream()
                        .filter(writtenBy -> isbns.contains(writtenBy.getIsbn()))
                        .collect(Collectors.toList());

                model.addAttribute("customer", customer);
                model.addAttribute("books", books);
                model.addAttribute("publishers", publishers);
                model.addAttribute("authors", writtenByEntities);
            }
        }
        return "customer_details";
    }
}
