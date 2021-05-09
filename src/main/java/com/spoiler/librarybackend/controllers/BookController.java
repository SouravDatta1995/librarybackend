package com.spoiler.librarybackend.controllers;


import com.spoiler.librarybackend.model.Book;
import com.spoiler.librarybackend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> showBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        if(bookRepository.findBookByAuthorAndTitle(book.getAuthor(),book.getTitle()).isPresent()) {
            return ResponseEntity.of(Optional.of("Book already added"));
        }
        else {
            bookRepository.save(book);
            return ResponseEntity.of(Optional.of("New Book Added"));
        }
    }
    @PostMapping("/find")
    public List<Book> findBooks(@RequestBody Book book){
        String author = book.getAuthor()==null?"":book.getAuthor();
        String title = book.getTitle()==null?"":book.getTitle();
        return bookRepository.findBooksByAuthorContainingAndTitleContaining(author,title);
    }
}
