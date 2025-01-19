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

    // CREATE: Menambahkan buku baru
    public BookResponse createBook(BookCreateRequest request) {
        // Validasi input
        if (request.getTitle() == null || request.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (request.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }

        // Membuat objek Book dari request
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());
        book.setCategoryId(request.getCategoryId());

        // Simpan ke database
        Book savedBook = bookRepository.save(book);

        // Kembalikan response
      // Kembalikan response
      return new BookResponse(
        savedBook.getId(),
        savedBook.getTitle(),
        savedBook.getAuthor(),
        savedBook.getDescription(),  // Menambahkan description
        savedBook.getPrice(),
        savedBook.getStock(),
        savedBook.getCategoryId()  // Menambahkan categoryId
    );
    

    }

    // DELETE: Menghapus buku berdasarkan ID
    public void deleteBook(Integer id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book with ID " + id + " not found");
        }
    }
}
