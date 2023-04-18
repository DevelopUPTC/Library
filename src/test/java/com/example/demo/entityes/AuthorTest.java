package com.example.demo.entityes;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {

    private Author author;

    private void setup(){
        author = new Author("George R.R Martin", LocalDate.of(1952, Month.JUNE,21));
    }

    @Test
    void findBook() {
        setup();
        //assertNull( author.findBook( new Book(22,null,(short)0,0)));

    }

    @Test
    void addBook() {
        setup();
        //assertTrue( author.addBook( new Book(2,"Juego de Tronos",(short)892,1996)));
        //assertFalse( author.addBook( new Book(2,"Juego de Tronos",(short)892,1996)));
    }

    @Test
    void getAge() {
    }
}