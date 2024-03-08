package com.bookz.store.controller;

import com.bookz.store.model.Book;
import com.bookz.store.model.Userr;
import com.bookz.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/new")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody Userr user){
    this.userService.addUser(user);
    }

    @PostMapping("/newBook")
    public void createBook(@RequestBody Book book){
        this.userService.addBook(book);
    }

}
