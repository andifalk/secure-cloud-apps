package com.example.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by afa on 2/12/17.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findOneByIdentifier(UUID identifier);

}
