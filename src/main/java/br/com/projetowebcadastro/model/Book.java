package br.com.projetowebcadastro.model;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private Integer pages;
    private Integer year;

    public Book(String title, String author, String publisher, Integer pages, Integer year) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.year = year;
    }
}
