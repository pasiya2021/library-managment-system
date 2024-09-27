package org.example.service;

import org.example.dto.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {


    void addBook(Book book);
}
