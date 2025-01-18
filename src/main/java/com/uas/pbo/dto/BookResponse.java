package com.uas.pbo.dto;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private Double price;
    private Integer stock;

    // Constructor
    public BookResponse(Long id, String title, String author, Double price, Integer stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
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

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
}
