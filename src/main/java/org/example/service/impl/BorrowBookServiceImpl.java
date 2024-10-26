package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.Entity.BorrowBookEntity;
import org.example.dto.BorrowBook;
import org.example.repository.BorrowBookRepository;
import org.example.service.BorrowBookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BorrowBookServiceImpl implements BorrowBookService {

    private final BorrowBookRepository repository;
    private final ModelMapper mapper;



    @Override
    public void saveDetails(BorrowBook borrowBook) {

        repository.save(mapper.map(borrowBook, BorrowBookEntity.class));

    }

    @Override
    public List<BorrowBookEntity> getAll() {
        return repository.findAll();
    }
}
