package com.example.demo.services;

import com.example.demo.entityes.Book;
import com.example.demo.repositories.RepositorieBook;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceBook {
    private RepositorieBook repositorieBook;

    public ServiceBook(RepositorieBook repositorieBook) {
        this.repositorieBook = repositorieBook;
    }


    public List<Book> findAll(){

        return repositorieBook.findAll();
    }

    public Book findById(Integer id){

        Optional<Book> book = repositorieBook.findById(id);

        return book.isPresent() ? book.get() : null;
    }

    public Book save( Book book ){
        return repositorieBook.save( book );
    }
}
