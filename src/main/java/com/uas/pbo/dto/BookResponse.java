package com.uas.pbo.dto;

 public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String description;
    private Double price;
    private Integer stock;
    private Integer categoryId;

    // Constructor
    public BookResponse(Long id, String title, String author, String description, Double price, Integer stock, Integer categoryId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
