package com.example.security;

/**
 * User info for user endpoint.
 */
public class UserInfo {

    private final User user;

    public UserInfo(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }

    public String getEmail() {
        return user.getEmail();
    }
}
