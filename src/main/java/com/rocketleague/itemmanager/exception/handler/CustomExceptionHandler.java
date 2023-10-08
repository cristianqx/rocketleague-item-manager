package com.rocketleague.itemmanager.exception.handler;

import com.rocketleague.itemmanager.domain.ErrorResponse;
import com.rocketleague.itemmanager.exception.ForbiddenException;
import com.rocketleague.itemmanager.exception.PathExistingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class CustomExceptionHandler {

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleForbiddenException(ForbiddenException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(PathExistingException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlePathExistingException(PathExistingException ex) {
        return new ErrorResponse(ex.getMessage());
    }

}
