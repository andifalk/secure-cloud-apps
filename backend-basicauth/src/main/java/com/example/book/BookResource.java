package com.example.book;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.hateoas.ResourceSupport;

import java.util.UUID;

/**
 * Created by afa on 2/12/17.
 */
@JsonRootName("book")
public class BookResource extends ResourceSupport {

    private final Book book;

    public BookResource(Book book) {
        this.book = book;
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public String getTitle() {
        return book.getTitle();
    }

    public String getIsbn() {
        return book.getIsbn();
    }

    public UUID getIdentifier() {
        return book.getIdentifier();
    }
}
