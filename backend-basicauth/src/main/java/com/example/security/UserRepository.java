package com.example.security;

import org.springframework.data.repository.CrudRepository;

/**
 * Data access layer for {@link User users}.
 */
public interface UserRepository extends CrudRepository<User,Long> {

    User findOneByEmail(String email);

    User findOneByIdentifier(String identifier);

}
