package org.example.service;

import org.example.Entity.BookEntity;
import org.example.dto.Book;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {


    void addBook(Book book);

    List<BookEntity> getBooks();

    boolean deleteBook(Long id);

    Book getBookById(Long id);
}
