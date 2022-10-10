package com.example.demo_db.controllers;

import com.example.demo_db.model.Student;
import com.example.demo_db.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private TestRepository testRepository;

    @Autowired
    public TestController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping("/test")
    public List<Student> getIndex(){
        return testRepository.getAllStudents();
    }
}
