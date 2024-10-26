package org.example.repository;

import org.example.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {



    boolean existsBookByTitle(String title);

    public BookEntity findByTitle(String title);
}
