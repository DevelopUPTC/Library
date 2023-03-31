package com.example.demo.controllers;

import com.example.demo.entityes.Book;
import com.example.demo.services.ServiceBook;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")

public class ControllerBook {
    private ServiceBook serviceBook;

    public ControllerBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    @GetMapping
    public List<Book> getBooks(){

        return serviceBook.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id){

        return serviceBook.findById( id );
    }

    @PostMapping
    public Book saveBook( @RequestBody Book book ){

        if( serviceBook.findById( book.getId()) == null ){
            return serviceBook.save( book );
        }

        return null;
    }

}
