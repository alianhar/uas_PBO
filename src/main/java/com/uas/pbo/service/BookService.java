package com.uas.pbo.service;

import com.uas.pbo.dto.BookCreateRequest;
import com.uas.pbo.dto.BookResponse;
import com.uas.pbo.model.Book;
import com.uas.pbo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookResponse createBook(BookCreateRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());
        book.setCategory(request.getCategory());
        book.setStock(request.getStock());

        Book savedBook = bookRepository.save(book);

        // Mengembalikan BookResponse
        return new BookResponse(
            savedBook.getId(),
            savedBook.getTitle(),
            savedBook.getAuthor(),
            savedBook.getDescription(),
            savedBook.getPrice(),
            savedBook.getCategory(),
            savedBook.getStock());
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setDescription(updatedBook.getDescription());
                    book.setPrice(updatedBook.getPrice());
                    book.setCategory(updatedBook.getCategory());
                    book.setStock(updatedBook.getStock());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book with ID" + id + "not found");
        }
    }
}
