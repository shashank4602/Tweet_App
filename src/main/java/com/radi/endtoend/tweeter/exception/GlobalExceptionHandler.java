package com.radi.endtoend.tweeter.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TweetNotFoundException.class)
    public ResponseEntity<String> notweetfound(TweetNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage()+">>> Please check if you have passed correct ID");
    }
}
