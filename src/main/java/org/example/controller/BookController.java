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
public class BookController {

    @Autowired
    BookService service;

    //add method to add book

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addBook(@RequestBody Book book) {

        service.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    @GetMapping("/get")
    public List<BookEntity> getBooks() {
        return service.getBooks();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
        return service.deleteBook(id)? ResponseEntity.ok("Book deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");


    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book getBookById(@PathVariable("id") Long id) {
        return service.getBookById(id);
    }
}
