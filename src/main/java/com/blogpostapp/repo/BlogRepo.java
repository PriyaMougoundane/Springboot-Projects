package com.blogpostapp.repo;

import com.blogpostapp.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long> {


    public List<Blog> findAll();
    public Optional<Blog> findById(Long id);

    @Query(value = "select * from Blogs b where not  exists (select blg_id from comments c\n" +
            "where c.blg_id = b.id )", nativeQuery = true)
    public List<Blog> findBlogWithNoComments() ;





}
