package com.bookz.store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

    private Integer publishedAt;
    private String author;
    private String name;
    @Id
    @GeneratedValue()
    private Long id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedAt(Integer publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublishedAt() {
        return publishedAt;
    }

}
