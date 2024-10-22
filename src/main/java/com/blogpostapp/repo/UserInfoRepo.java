package com.blogpostapp.repo;

import com.blogpostapp.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Integer> {
    public Optional <UserInfo> findByName(String username);
}
