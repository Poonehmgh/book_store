package com.bookz.store.repo;

import com.bookz.store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Optional<Book> findByName(String name);

    List<Book> findByNameContaining(String name);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByPublishedAt(Integer publishedAt);
}
