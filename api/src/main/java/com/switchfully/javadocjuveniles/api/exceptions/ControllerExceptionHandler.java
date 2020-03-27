package com.switchfully.javadocjuveniles.api.exceptions;


import com.switchfully.javadocjuveniles.api.endpoints.MemberController;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailAlreadyRegisteredException;
import com.switchfully.javadocjuveniles.domain.exceptions.EmailNotValidException;
import com.switchfully.javadocjuveniles.domain.exceptions.MemberNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @ExceptionHandler(EmailNotValidException.class)
    protected void emailNotValidException(EmailNotValidException ex, HttpServletResponse response) throws IOException {
        logger.error("Email is not valid!", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(EmailAlreadyRegisteredException.class)
    protected void emailAlreadyRegisteredException(EmailAlreadyRegisteredException ex, HttpServletResponse response) throws IOException {
        logger.error("Email is already registered!", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(MemberNotFoundException.class)
    protected void memberNotFoundException(MemberNotFoundException ex, HttpServletResponse response) throws IOException {
        logger.error("Could not find any member.", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

}
