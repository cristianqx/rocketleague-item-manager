package com.rocketleague.itemmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)

public class PathExistingException extends Exception {

    public PathExistingException(String message) {
        super(message);
    }
}
