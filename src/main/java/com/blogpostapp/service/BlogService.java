package com.blogpostapp.service;

import com.blogpostapp.entities.Blog;

import java.util.List;

public interface BlogService {

    public Blog createBlog(Blog blog);
    public Blog updateBlog(Long bid, Blog blog);
    public Blog deleteBlog(long bid);
    public List<Blog> getAllBlogs();
    public Blog getById(Long id);
    public List<Blog> getBlogWithNoComments();


}
