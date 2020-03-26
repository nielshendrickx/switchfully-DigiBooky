package com.switchfully.javadocjuveniles.api.exceptions;


import com.switchfully.javadocjuveniles.domain.exceptions.EmailNotValidException;
import org.hibernate.validator.constraints.Email;
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
    //private final Logger logger = LoggerFactory.getLogger(ProfessorController.class); //TODO create logger after setting up the user controller

    @ExceptionHandler(EmailNotValidException.class)
    protected void professorDoesNotExistsException(EmailNotValidException ex, HttpServletResponse response) throws IOException {
        //logger.error("Email is not valid!", ex);
        response.sendError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
