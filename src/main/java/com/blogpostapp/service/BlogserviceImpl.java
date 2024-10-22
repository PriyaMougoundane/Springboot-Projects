package com.blogpostapp.service;

import com.blogpostapp.entities.Blog;
import com.blogpostapp.exception.BlogNotFound;
import com.blogpostapp.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogserviceImpl implements BlogService{
    @Autowired
    private BlogRepo blogRepo;

    public BlogserviceImpl(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    @Override
    public Blog createBlog(Blog blog) {
       blogRepo.save(blog);
       return blog;

    }

    @Override
    public Blog updateBlog(Long bid, Blog blog) {
       Blog blogToUpdate = getById(bid);
       blogToUpdate.setContent(blog.getContent());

         blogRepo.save(blogToUpdate);
         return blogToUpdate;


    }

    @Override
    public Blog deleteBlog(long bid) {
     Blog blogToDelete = getById(bid);

     blogRepo.delete(blogToDelete);


        return blogToDelete;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();

    }

    @Override
    public Blog getById(Long id) {

        return blogRepo.findById(id).orElseThrow(() -> new BlogNotFound("The requested Blog " + id + " not found"));

    }


    @Override
    public List<Blog> getBlogWithNoComments() {

        return blogRepo.findBlogWithNoComments();

    }
}
