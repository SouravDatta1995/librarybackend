package com.spoiler.librarybackend.controllers;


import com.spoiler.librarybackend.models.Book;
import com.spoiler.librarybackend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public ArrayList<Book> showBooks() {
        ArrayList<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @PostMapping("/add")
    public Book addBook( Book book){
        bookRepository.save(book);
        return book;
    }
}
