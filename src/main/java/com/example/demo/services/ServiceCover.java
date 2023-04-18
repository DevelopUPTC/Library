package com.example.demo.services;

import com.example.demo.repositories.RepositorieCover;
import org.springframework.stereotype.Service;

@Service
public class ServiceCover {

    private RepositorieCover repositorieCover;

    public ServiceCover(RepositorieCover repositorieCover) {
        this.repositorieCover = repositorieCover;
    }
}
