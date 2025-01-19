package com.uas.pbo.dto;

import com.uas.pbo.model.Category;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String description;
    private Double price;
    private Category category;
    private Integer stock;

    // Constructor
    public BookResponse(Long id, String title, String author, String description, Double price, Category category, Integer stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

       // Getters and Setters
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}