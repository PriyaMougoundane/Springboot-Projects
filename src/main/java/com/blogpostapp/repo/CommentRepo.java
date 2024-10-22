package com.blogpostapp.repo;

import com.blogpostapp.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Long> {

    public List<Comments> findAll();

    public Optional<Comments> findById(Long cid);


    public List<Comments> findByBlogId(Long bid );

    public Comments findByIdAndBlogId(Long bid, Long cid);


}
