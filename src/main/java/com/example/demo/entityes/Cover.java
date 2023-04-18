package com.example.demo.entityes;

import jakarta.persistence.*;

@Entity(name = "covers")
public class Cover {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String author;

    @Column(nullable = false)
    private String url;

    @OneToOne(mappedBy = "cover")
    private Book book;

    public Cover() {
    }

    public Cover(Integer id, String author, String url) {
        this.id = id;
        this.author = author;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
