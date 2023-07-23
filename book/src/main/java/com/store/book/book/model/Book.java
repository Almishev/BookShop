package com.store.book.book.model;

import javax.persistence.*;

@Entity
@Table(name="all_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="author")
    private String author;
    @Column(name="price")
    private String price;
    public Book(int id, String name, String author, String price) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
    public Book() {
        super();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
