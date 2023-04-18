package com.example.demo.repositories;

import com.example.demo.entityes.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorieCover extends JpaRepository<Cover, Integer> {
}
