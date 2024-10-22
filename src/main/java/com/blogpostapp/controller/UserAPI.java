package com.blogpostapp.controller;

import com.blogpostapp.entities.UserInfo;
import com.blogpostapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import static com.blogpostapp.service.UserService.passwordEncoder;

@RestController

public class UserAPI {

    @Autowired
   private UserService userService;


    @Autowired
    private static PasswordEncoder passwordEncoder;

    public UserAPI(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(path = "/User/addUser")
    public static UserInfo addUser(@RequestBody UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
      return UserService.addUserInfo(userInfo);




}
}
