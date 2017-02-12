package com.example.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User endpoint.
 */
@RestController
public class UserRestController {

    @RequestMapping(path = "/currentuser", method = RequestMethod.GET)
    public UserInfo currentUser(@AuthenticationPrincipal User user) {
        return new UserInfo(user);
    }

}
