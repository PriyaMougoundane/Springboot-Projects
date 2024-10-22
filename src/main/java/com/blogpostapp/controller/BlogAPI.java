package com.blogpostapp.controller;


import com.blogpostapp.entities.Blog;
import com.blogpostapp.service.BlogService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.logging.Logger;

@RestController

@RequestMapping(path = "api/Blog")

public class BlogAPI {


    @Autowired
    private BlogService blogService;

    public BlogAPI(BlogService blogService) {
        this.blogService = blogService;
    }

    Logger logger =  LoggerFactory.getLogger(BlogAPI.class);



    // Creation of new Blog

    @PostMapping(path = "blogcreation/{blog}")
    public ResponseEntity BlogCreation(@PathVariable Blog blog){
         return ResponseEntity.status(HttpStatus.CREATED).body(blogService.createBlog(blog));

    }

   //Update of the old blog

    @PutMapping(path = "blogupdate/{blogid}")
    public ResponseEntity<Blog> BlogUpdate(@PathVariable Long blogid, @RequestBody Blog blog){
      return ResponseEntity.status(HttpStatus.OK).body(blogService.updateBlog(blogid, blog));

    }


    //get all blogs
    @GetMapping(path = "showblogs")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<Blog>> showAllBlogs(){

        logger.info("get all blogs info");

       return ResponseEntity.status(HttpStatus.FOUND).body(blogService.getAllBlogs());

        //return  ResponseEntity<>("Data is found" , HttpStatus.FOUND);


    }

    // get blogs by id
    @GetMapping(path = "showById/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    /*
    public ResponseEntity<Blog> showById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(blogService.getById(id));


     */

    public Blog showById(@PathVariable Long id){
        return blogService.getById(id);
    }

    // get blogs with no comments

    @GetMapping(path = "noCommentBlog")
    public ResponseEntity<List<Blog>> noCommentBlog(){
        return ResponseEntity.status(HttpStatus.FOUND).body(blogService.getBlogWithNoComments());

    }

    //Delete blogs

    public ResponseEntity<Blog> deleteBlog(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(blogService.deleteBlog(id));
    }

}
