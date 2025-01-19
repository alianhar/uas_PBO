package com.uas.pbo.service;

import com.uas.pbo.dto.BookCreateRequest;
import com.uas.pbo.dto.BookResponse;
import com.uas.pbo.model.Book;
import com.uas.pbo.model.Category;
import com.uas.pbo.repository.BookRepository;
import com.uas.pbo.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // CREATE
    public BookResponse createBook(BookCreateRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCategoryId()));

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());
        book.setCategory(category);

        Book savedBook = bookRepository.save(book);

        return new BookResponse(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor());
    }

    // READ (Get All Books)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // READ (Get Book By ID)
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // UPDATE
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setStock(updatedBook.getStock());

        if (updatedBook.getCategory() != null) {
            Category category = categoryRepository.findById(updatedBook.getCategory().getId())
                    .orElseThrow(() -> new RuntimeException("Category not found with ID: " + updatedBook.getCategory().getId()));
            existingBook.setCategory(category);
        }

        return bookRepository.save(existingBook);
    }

    // DELETE
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
    }
}
