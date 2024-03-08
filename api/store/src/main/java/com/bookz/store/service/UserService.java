package com.bookz.store.service;

import com.bookz.store.UserRepo;
import com.bookz.store.model.Book;
import com.bookz.store.model.Userr;
import com.bookz.store.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookRepo bookRepo;


    public void addUser(Userr user){
        userRepo.save(user);
    }

    public void addBook(Book book){
        bookRepo.save(book);
    }
}
