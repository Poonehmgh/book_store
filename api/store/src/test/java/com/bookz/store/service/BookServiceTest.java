package com.bookz.store.service;

import com.bookz.store.repo.BookRepo;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.bookz.store.model.Book;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepo;

    @InjectMocks
    private BookService bookService;



    /*The @Before annotation is a JUnit annotation that marks a method to be executed
    before each test method in the class. This means the setUp method will run
    before every test you write in the same class.Inside the setUp method,
    MockitoAnnotations.initMocks(this) is called.
    This method scans the current test object (this) for fields annotated with
    Mockito annotations (like @Mock). It then initializes those mocked fields by
    creating mock objects using Mockito.*/
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddBook_duplicateName() throws Exception{

        MockitoAnnotations.initMocks(this);
        Book newBook = new Book("Lord of the rings", "Tolkien", 1975);

        /*mock the findBy name behavior*/
        when(bookRepo.findByName(newBook.getName())).thenReturn(Optional.of(new Book()));
        /*we expect the exception to be thrown*/

        assertThrows(RuntimeException.class, ()->{
        bookService.addBook(newBook);
        });
    }


    @Test
    public void addBook_saving(){
        MockitoAnnotations.initMocks(this);

        Book newBook = new Book("Sample", "Sample", 1200);

        /*mock bookRep.findByName*/
        when(bookRepo.findByName(newBook.getName())).thenReturn(Optional.empty());
        /*stubb bookRepo.save*/
        when(bookRepo.save(Mockito.any(Book.class))).thenAnswer(i -> i.getArgument(0));

        /*call addBook*/
        bookService.addBook(newBook);

        /*verify that the bookRepo.save is being called with the newBook*/
        verify(bookRepo).save(newBook);
    }

    @Test
    public void getBookWhenNoInput(){
        MockitoAnnotations.initMocks(this);

        BookRepo bookRepo = mock(BookRepo.class);
        Book testBook = new Book("test", "test", 1999);

        when(bookRepo.findByName("test")).thenReturn(Optional.of(testBook));
        Optional<Book>  result = bookService.getBook("test");

        assertEquals(Optional.of(testBook), result);
        verify(bookRepo).findByName("test");

    }
}