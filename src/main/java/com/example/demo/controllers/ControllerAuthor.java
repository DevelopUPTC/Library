package com.example.demo.controllers;

import com.example.demo.entityes.Author;
import com.example.demo.services.ServiceAuthor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class ControllerAuthor {

    private ServiceAuthor serviceAuthor;

    public ControllerAuthor(ServiceAuthor serviceAuthor) {
        this.serviceAuthor = serviceAuthor;
    }

    @GetMapping
    public List<Author> findAll(){
        return serviceAuthor.findAll();
    }

}
