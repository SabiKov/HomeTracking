package com.sabi11.hometracking.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // applicable to all controller class
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        CustomErrorDetails customErrorDetails =
                new CustomErrorDetails(
                        new Date(),
                        "From method argument not valid exception",
                        ex.getMessage());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
//        return this.handleExceptionInternal(
//                ex,
//                (Object)null,
//                headers,
//                status,
//                request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        CustomErrorDetails customErrorDetails =
                new CustomErrorDetails(
                        new Date(),
                        "From HttpRequestMethodNoSupportedException - Method forbidden",
                        ex.getMessage());
        return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
//        return this.handleExceptionInternal(
//                ex,
//                (Object)null,
//                headers,
//                status,
//                request);
    }

    @ExceptionHandler(value = {UserIdNotFoundException.class})
    public final ResponseEntity<Object> handleUserIdNotFoundException(
            UserIdNotFoundException ue, WebRequest webRequest) {
        CustomErrorDetails customErrorDetails =
                new CustomErrorDetails(
                        new Date(),
                        ue.getMessage(),
                        webRequest.getDescription(false));
        return new ResponseEntity<>(customErrorDetails, HttpStatus.NOT_FOUND);
    }
}
