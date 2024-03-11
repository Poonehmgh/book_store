package com.bookz.store.controller;

import com.bookz.store.model.Book;
import com.bookz.store.model.Userr;
import com.bookz.store.service.BookService;
import com.bookz.store.service.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/new")
@RestController
public class UserController {

    private final UserService userService;
    private final BookService bookService;

    @Autowired
    public UserController(UserService userService, BookService bookService){
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody Userr user){
    this.userService.addUser(user);
    }

    @PostMapping("/newBook")
    public void createBook(@RequestBody Book book){
        this.bookService.addBook(book);
    }

    @PostMapping("getBook")
    public Optional<Book> getBook(@RequestBody Book book){
        return this.bookService.getBook(book.getName());
    }

    @GetMapping("allBooks")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    @PostMapping("updateBook")
    public void updateBook(@RequestBody Book book)
    {
         this.bookService.updateBookByName(book);
    }

    @DeleteMapping("deleteBook")
    public void deleteBook(@RequestBody Book book){
        this.bookService.deleteBookByName(book.getName());
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String name, @RequestParam(required = false) String author, @RequestParam(required = false) Integer publishedAt){

        return bookService.searchBooks(name, author, publishedAt);

    }

}
