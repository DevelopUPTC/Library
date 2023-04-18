package com.example.demo.repositories;

import com.example.demo.entityes.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAuthor extends JpaRepository<Author,Integer> {
}
