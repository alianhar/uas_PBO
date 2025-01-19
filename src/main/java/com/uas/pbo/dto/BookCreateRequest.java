package com.uas.pbo.dto;

public class BookCreateRequest {
    private String title;
    private String author;
    private String description;
    private Double price;
    private Long categoryId; // Category ID
    private Integer stock;

    // Getter dan Setter
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

    public Long getCategoryId() { 
        return categoryId; 
    }
    public void setCategoryId(Long categoryId) {
         this.categoryId = categoryId; 
    }

    public Integer getStock() {
         return stock;
    }
    public void setStock(Integer stock) {
         this.stock = stock; 
    }
}

