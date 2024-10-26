package org.example.repository;

import org.example.Entity.BorrowBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBookEntity, Long> {
}
