package com.example.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by afa on 2/12/17.
 */
@RestController
@RequestMapping(path = "/books")
public class BookRestController {

    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(path = "/{bookIdentifier}", method = RequestMethod.GET)
    public ResponseEntity<?> findOneByIdentifier(UUID identifier) {
        Book book = bookService.findOneByIdentifier(identifier);
        if (book != null) {
            return ResponseEntity.ok(new BookResource(book));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BookResource>> findAll() {
        return ResponseEntity.ok(
                        bookService.findAll()
                                .stream()
                                .map(BookResource::new)
                                .collect(Collectors.toList()));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BookResource> create(@Valid @RequestBody CreateBookResource createBookResource) {
        Book bookToCreate = new Book();
        bookToCreate.setTitle(createBookResource.getTitle());
        bookToCreate.setAuthor(createBookResource.getAuthor());
        bookToCreate.setIsbn(createBookResource.getIsbn());
        Book persistentBook = bookService.save(bookToCreate);
        return ResponseEntity.created(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{bookIdentifier}")
                .buildAndExpand(persistentBook.getIdentifier()).toUri()).body(new BookResource(persistentBook));
    }
}
