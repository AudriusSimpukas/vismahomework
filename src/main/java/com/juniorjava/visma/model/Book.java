package com.juniorjava.visma.model;

import java.util.Date;

public class Book {

    private String name;
    private String author;
    private String category;
    private String language;
    private Date publicationDate;
    private Long isbn;
    private String guid;

    public Book(String name,
                String author,
                String category,
                String language,
                Date publicationDate,
                Long isbn,
                String guid) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.language = language;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getGuid() {
        return guid;
    }

}
