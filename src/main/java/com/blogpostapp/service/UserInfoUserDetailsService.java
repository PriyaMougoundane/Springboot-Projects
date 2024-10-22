package com.blogpostapp.service;

import com.blogpostapp.Config.USerInfoUSerDetails;
import com.blogpostapp.entities.UserInfo;
import com.blogpostapp.repo.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserInfoUserDetailsService implements UserDetailsService {
  @Autowired
    private UserInfoRepo repository;

    public UserInfoRepo getRepository() {
        return repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> userInfo = repository.findByName(username);
        return userInfo.map(USerInfoUSerDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found "+ username));
    }
}
