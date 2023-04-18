package com.example.demo.entityes;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column( length = 40, nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthday;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public Author(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Book findBook( Book book ){
        Optional< Book > optBook = books.stream()
                .filter( b -> book.getId() == b.getId() )
                .findFirst();

        return optBook.isPresent() ? optBook.get() : null;
    }

    public boolean addBook( Book book ){
        if ( findBook( book ) == null ){
            books.add( book );

            return true;
        }

        return false;
    }

    public int getAge(){

        return Period.between( birthday, LocalDate.now() ).getYears();
    }
}
