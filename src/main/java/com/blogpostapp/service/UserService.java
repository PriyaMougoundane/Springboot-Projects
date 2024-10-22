package com.blogpostapp.service;


import com.blogpostapp.entities.UserInfo;
import com.blogpostapp.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private static UserInfoRepo repository;

    public UserService(UserInfoRepo repository) {
        this.repository = repository;
    }

    public static UserInfo addUserInfo(UserInfo userInfo){
        //userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
         repository.save(userInfo);

        return userInfo;
    }
}
