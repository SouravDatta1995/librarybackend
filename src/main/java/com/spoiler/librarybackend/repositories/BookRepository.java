package com.spoiler.librarybackend.repositories;

import com.spoiler.librarybackend.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository("BookRepository")
public interface BookRepository extends MongoRepository<Book, Integer> {

    List<Book> findBooksByAuthorContainingAndTitleContaining (String author, String title);
    Optional<Book> findBookByAuthorAndTitle (String author, String title);
}
