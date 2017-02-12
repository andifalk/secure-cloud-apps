package com.example.book;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by afa on 2/12/17.
 */
public interface BookService {
    Book findOneByIdentifier(UUID identifier);

    List<Book> findAll();

    @Transactional
    Book save(Book book);
}
