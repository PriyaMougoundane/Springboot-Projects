package com.blogpostapp.exception;

public class CommentsNotFound extends RuntimeException{

    public CommentsNotFound(String message) {
        super(message);
    }
}
