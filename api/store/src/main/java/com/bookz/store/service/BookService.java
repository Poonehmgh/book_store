package com.bookz.store.service;

import com.bookz.store.model.Book;
import com.bookz.store.repo.BookRepo;
import com.bookz.store.repo.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    private BookRepo bookRepo;



    public void addBook(Book book){
        if (this.bookRepo.findByName(book.getName()).isPresent())
            throw new RuntimeException("A book with the same name already exists.");
        else
            bookRepo.save(book);
    }

    public Optional<Book> getBook(String name){
        return (this.bookRepo.findByName(name));
    }

    public List<Book> getAll(){
    return (this.bookRepo.findAll());
    }

    public void updateBookByName(Book book){
        Optional<Book> bookOpts= this.bookRepo.findByName(book.getName());
        if (bookOpts.isPresent()){
            Book existingBook = bookOpts.get();
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPublishedAt(book.getPublishedAt());
            this.bookRepo.save(existingBook);
        }
        else
            throw new RuntimeException("Book not found: " + book.getName());
    }

    public void deleteBookByName(String name){
        Optional<Book> bookOpts= this.bookRepo.findByName(name);
        if (bookOpts.isPresent()){
            Book existingBook = bookOpts.get();
            this.bookRepo.delete(existingBook);
        }
        else
            throw new RuntimeException("No such book was found to be deleted: " + name);
    }

    public List<Book> searchBooks(String name, String author, Integer year){
//        return this.bookRepo.findByNameContaining(name);
        Specification<Book> spec = Specification.where(BookSpecification.hasName(name))
                .and(BookSpecification.hasAuthor(author))
                .and(BookSpecification.hasPublishedAt(year));
        return this.bookRepo.findAll(spec);
    }
 }
