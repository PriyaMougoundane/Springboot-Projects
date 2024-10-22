package com.blogpostapp.controller;


import com.blogpostapp.dto.ErrorMessage;
import com.blogpostapp.exception.BlogNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice

public class ExceptionHandlerController {

    @ExceptionHandler(BlogNotFound.class)
    public ResponseEntity<Object>handle404(BlogNotFound ex){

       HashMap<String,Object> hashMap = new HashMap<>();
        ErrorMessage errorMessage = ErrorMessage.builder()
                .errorMessage(ex.getMessage())
                .errorCode(String.valueOf(HttpStatus.NOT_FOUND))
                // .object(blog)
                .contact("priya.mukund7@gmail.com")
                .timestamp(LocalDateTime.now())
                .build();

        hashMap.put("errorMessage",errorMessage);
        //hashMap.put("Blog items", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap);





    }


}
