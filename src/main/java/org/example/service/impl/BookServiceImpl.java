package org.example.service.impl;

import org.example.Entity.BookEntity;
import org.example.dto.Book;
import org.example.repository.BookRepository;
import org.example.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;


    ModelMapper mapper;

    @Bean
    public void setup() {
        this.mapper = new ModelMapper();
    }

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
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

}
