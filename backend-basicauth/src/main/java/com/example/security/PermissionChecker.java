package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * Created by afa on 2/12/17.
 */
@Service
public class PermissionChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionChecker.class);

    public boolean checkPermission(Authentication authentication, String permission) {
        LOGGER.info("Check permission {} for principal {}", authentication.getPrincipal(), permission);
        return true;
    }

}
