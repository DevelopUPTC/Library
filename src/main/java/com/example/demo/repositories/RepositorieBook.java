package com.example.demo.repositories;

import com.example.demo.entityes.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorieBook extends JpaRepository<Book, Integer> {

}
