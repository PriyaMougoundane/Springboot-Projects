package com.blogpostapp.exception;

public class BlogNotFound extends RuntimeException{

    public BlogNotFound(String message) {
        super(message);
    }
}
