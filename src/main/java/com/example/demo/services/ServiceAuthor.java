package com.example.demo.services;

import com.example.demo.entityes.Author;
import com.example.demo.repositories.RepositoryAuthor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceAuthor {
    private RepositoryAuthor repositoryAuthor;

    public ServiceAuthor(RepositoryAuthor repositoryAuthor) {
        this.repositoryAuthor = repositoryAuthor;
    }

    public List<Author> findAll(){
        return repositoryAuthor.findAll();
    }
}
