package org.example.repository;

import org.example.Entity.BookEntity;
import org.example.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
