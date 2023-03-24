package com.revature.complaintsubmissionsj11.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UserNotFoundException extends Exception {

    Logger logger1 = LoggerFactory.getLogger(UserNotFoundException.class);

    public UserNotFoundException() {
        super("Incorrect Log-In");
        logger1.error("Incorrect Log-In");
    }
}
