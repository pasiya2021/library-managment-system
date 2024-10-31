package org.example.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Entity.BorrowBookEntity;
import org.example.dto.BorrowBook;
import org.example.service.BorrowBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BorrowBookController {

    private final BorrowBookService service;

    @PostMapping("/borrow")
    public void borrowBook(@RequestBody BorrowBook borrowBook) {

        service.saveDetails(borrowBook);
        log.info("Borrowed book: {}", borrowBook);
    }

    @GetMapping("/get-all")
    public List<BorrowBookEntity> getAll(){
        return service.getAll();
    }




}
