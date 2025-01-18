package com.uas.pbo.service;

import com.uas.pbo.dto.BookCreateRequest;
import com.uas.pbo.dto.BookResponse;
import com.uas.pbo.model.Book;
import com.uas.pbo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookResponse createBook(BookCreateRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());

        Book savedBook = bookRepository.save(book);

        // Mengembalikan BookResponse
        return new BookResponse(
            savedBook.getId(),
            savedBook.getTitle(),
            savedBook.getAuthor(),
            savedBook.getPrice(),
            savedBook.getStock()
        );
    }
}
