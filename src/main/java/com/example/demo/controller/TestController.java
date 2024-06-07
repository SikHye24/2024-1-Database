package com.example.demo.controller;

import com.example.demo.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.domain.TestEntity;

import java.util.List;

@RestController
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/home")
    public String home() {
        return "Hello World";
    }

    @GetMapping(value = "/example")
    public ModelAndView ViewExample() {
        ModelAndView modelAndView = new ModelAndView("example");
        modelAndView.addObject("name", "Example Name");
        return modelAndView;
    }

    @GetMapping(value = "/tests")
    public ModelAndView ViewTests() {
        ModelAndView modelAndView = new ModelAndView("tests");
        List<TestEntity> testEntities = testService.findAll();
        modelAndView.addObject("tests", testEntities);
        return modelAndView;
    }
    @GetMapping(value = "/testById")
    public ModelAndView SelectTest() {
        ModelAndView modelAndView = new ModelAndView("testById");
        TestEntity testEntity = testService.findById(1);
        modelAndView.addObject("test", testEntity);
        return modelAndView;
    }
}