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

//    @DeleteMapping("/delete/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<String> deleteBook(@PathVariable("id") Long id) {
//        return service.deleteBook(id)? ResponseEntity.ok("Book deleted successfully") : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
//
//
//    }

    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable("isbn") String isbn) {
        service.deleteBookByIsbn(isbn);
        return ResponseEntity.ok("Book deleted successfully");
    }

//
//    @GetMapping("/search/{id}")
//    public Book getBookById(@PathVariable Long id) {
//        return service.getBookById(id);
//    }
//
//
    @GetMapping("/get/{title}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book getBookByTitle(@PathVariable("title") String title) {
        return service.getBookByTitle(title);
    }

    @GetMapping("/search/{id}")
    public Book getBookById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PutMapping("/update/{isbn}")
    public ResponseEntity<String> updateBook(@PathVariable("isbn") String isbn, @RequestBody Book updatedBook) {
        service.updateBook(isbn, updatedBook);
        return ResponseEntity.ok("Book updated successfully");

    }

}
