package com.nashtech.nashtech_shop.APIController.exceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.nashtech.nashtech_shop.model.ErrorMessage;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class APIHandlerException {


    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public static ErrorMessage NotFoundException(String name) {
        return new ErrorMessage(404, name);

    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public static ErrorMessage IntenalServerException() {
        return new ErrorMessage(500, "Not Found exception");

    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public static ErrorMessage IntenalServerException2() {
        return new ErrorMessage(500, "Not Found exception");

    }

    @ExceptionHandler(value = JsonParseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public static ErrorMessage BadRequestException2() {
        return new ErrorMessage(400, "Bad Request");
    }
}
