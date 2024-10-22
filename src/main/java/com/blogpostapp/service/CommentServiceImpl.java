package com.blogpostapp.service;

import com.blogpostapp.entities.Comments;
import com.blogpostapp.exception.CommentsNotFound;
import com.blogpostapp.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public Comments addComment(Comments comments) {

     try{
       if (comments != null) {
           commentRepo.save(comments);
       }

     } catch (NullPointerException e) {
         throw new RuntimeException("Expected a value, it cannot be null", e);
     }
    return comments;

    }

    @Override
    public Comments updateComment(Long cid, Comments comments) {

        Comments commentToUpdate = getCommentById(cid);
        commentToUpdate.setComment(comments.getComment());
        commentRepo.save(commentToUpdate);
        return commentToUpdate;
    }

    @Override
    public Comments deleteComment(Long cid) {

        Comments commentToDelete = getCommentById(cid);
        commentRepo.delete(commentToDelete);

                return commentToDelete;

    }

    @Override
    public List<Comments> getAllComments() {


        return commentRepo.findAll();

    }

    @Override
    public Comments getCommentById(Long cid) {
        //return commentRepo.findById(cid).orElseThrow(() -> new CommentsNotFound("The requested " + cid + "not found"));
        //return commentRepo.findById(cid).orElseThrow(() -> new RuntimeException("The requested " + cid + "not found"));
        Comments comments = null;
        try{
            if (cid != null) {
                 comments= commentRepo.findById(cid)
                         .orElseThrow(() ->
                        new CommentsNotFound("The requested " + cid + "not found"));
            }
            
        }catch (NullPointerException  e ){
            throw new RuntimeException("Comment id cannot be null");
            
        }
        return comments;

    }

    @Override
    public List<Comments> getAllCommentByBlogId(Long bid) {
        return commentRepo.findByBlogId(bid);

    }

    @Override
    public Comments getcommentByBlogId(Long bid, Long cid) {
        return commentRepo.findByIdAndBlogId(bid, cid);
    }
}
