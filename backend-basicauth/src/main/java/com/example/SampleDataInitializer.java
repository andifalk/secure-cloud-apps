package com.example;

import com.example.book.Book;
import com.example.book.BookRepository;
import com.example.security.User;
import com.example.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by afa on 2/3/17.
 */
@Component
public class SampleDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SampleDataInitializer(UserRepository userRepository, BookRepository bookRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User(UUID.randomUUID(), "Hans", "User",
                "user@example.com", passwordEncoder.encode("secretpassword")));
        userRepository.save(new User(UUID.randomUUID(), "Peter", "Admin",
                "admin@example.com", passwordEncoder.encode("adminpassword")));

        Book book = new Book();
        book.setIdentifier(UUID.randomUUID());
        book.setAuthor("Josh Long");
        book.setTitle("Cloud Native Java");
        book.setIsbn("978-1449374648");
        bookRepository.save(book);
    }
}
