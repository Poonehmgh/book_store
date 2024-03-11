package com.bookz.store.repo;

import com.bookz.store.model.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {
    public static Specification<Book> hasName(String name){
        return ((root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty())
                return criteriaBuilder.conjunction();
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");});
    }
    public static Specification<Book> hasAuthor(String author){
        return ((root, query, criteriaBuilder)->{
            if (author == null || author.isEmpty())
                return criteriaBuilder.conjunction();
            return criteriaBuilder.like(root.get("author"), "%" + author + "%");
        });
    }

    public static Specification<Book> hasPublishedAt(Integer year) {
        return (root, query, criteriaBuilder) -> {
            if (year == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("publishedAt"), year);
        };
    }
}
