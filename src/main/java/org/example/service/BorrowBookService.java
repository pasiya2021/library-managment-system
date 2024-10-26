package org.example.service;

import org.example.Entity.BorrowBookEntity;
import org.example.dto.BorrowBook;

import java.util.List;

public interface BorrowBookService {

    void saveDetails(BorrowBook borrowBook);

    List<BorrowBookEntity> getAll();
}
