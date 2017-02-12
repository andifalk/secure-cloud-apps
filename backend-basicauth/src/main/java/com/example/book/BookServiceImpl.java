package com.example.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by afa on 2/12/17.
 */
@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findOneByIdentifier(UUID identifier) {
        return bookRepository.findOneByIdentifier(identifier);
    }

    @PreAuthorize("@permissionChecker.checkPermission(authentication, 'test')")
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book save(Book book) {
        if (book.getIdentifier() == null) {
            book.setIdentifier(UUID.randomUUID());
        }
        return bookRepository.save(book);
    }
}
