package org.example.controller;

import org.example.Entity.BookEntity;
import org.example.dto.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@ResponseStatus(HttpStatus.CREATED)
public class BookController {

    @Autowired
    BookService service;

    //add method to add book

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {

        service.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    @GetMapping("/get")
    public List<BookEntity> getBooks() {
        return service.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        service.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
