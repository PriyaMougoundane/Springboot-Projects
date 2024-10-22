package com.blogpostapp.service;

import com.blogpostapp.entities.Comments;

import java.util.List;

public interface CommentService {

    public Comments addComment(Comments comments);
    public Comments updateComment(Long cid , Comments comments);
    public Comments deleteComment(Long cid);
    public List<Comments> getAllComments();
    public Comments getCommentById(Long cid);
    public List<Comments> getAllCommentByBlogId(Long bid);
    public Comments getcommentByBlogId(Long bid, Long cid);


}
