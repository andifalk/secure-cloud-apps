package com.example.book;

import org.springframework.hateoas.ResourceSupport;

import java.util.Collection;

/**
 * Created by afa on 2/12/17.
 */
public class BookListResource extends ResourceSupport {

    private final Collection<BookResource> books;

    public BookListResource(Collection<BookResource> books) {
        this.books = books;
    }

    public Collection<BookResource> getBooks() {
        return books;
    }
}
