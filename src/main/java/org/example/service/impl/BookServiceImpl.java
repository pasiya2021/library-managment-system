package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.Entity.BookEntity;
import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository repository;
    private final ModelMapper mapper;


//    private final BookRepository repository;
//
//    @Autowired
//    public BookServiceImpl(BookRepository repository) {
//        this.repository = repository;
//    }
//    dependency injection is done by constructor - All final properties injected by constructor(dependency injection),dependency injection is done by constructor

//    ModelMapper mapper;
//
//    @Bean
//    public void setup() {
//        this.mapper = new ModelMapper();
//    }

    @Override
    public void addBook(Book book) {

        BookEntity entity = mapper.map(book,BookEntity.class);
        repository.save(entity);
    }

    @Override
    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Book getBookById(Long id) {
       Optional<BookEntity> byId = repository.findById(id);
       return mapper.map(byId,Book.class);

    }

    @Override
    public Book getBookByTitle(String title) {
       BookEntity byTitle =  repository.findByTitle(title);
       return mapper.map(byTitle,Book.class);
    }

    @Override
    public void updateBook(String isbn, Book updatedBook) {

        BookEntity book = repository.findByIsbn(isbn);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setCategory(updatedBook.getCategory());
            book.setQty(updatedBook.getQty());
            repository.save(book);
        }

    }

    @Override
    public void deleteBookByIsbn(String isbn) {
        BookEntity byIsbn = repository.findByIsbn(isbn);
        if (byIsbn != null) {
            repository.delete(byIsbn);
        }
    }


}
