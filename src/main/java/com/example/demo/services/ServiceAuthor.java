package com.example.demo.services;

import com.example.demo.entityes.Author;
import com.example.demo.repositories.RepositoryAuthor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ServiceAuthor {
    private RepositoryAuthor repositoryAuthor;

    public ServiceAuthor(RepositoryAuthor repositoryAuthor) {
        this.repositoryAuthor = repositoryAuthor;
    }

    public List<Author> findAll(){
        return repositoryAuthor.findAll();
    }

    public Author findById( Integer id ){

        Optional<Author> author = repositoryAuthor.findById( id );

        return author.isPresent() ? author.get() : null;
    }

    public Author save( Author author ){

        return repositoryAuthor.save( author );
    }
}
