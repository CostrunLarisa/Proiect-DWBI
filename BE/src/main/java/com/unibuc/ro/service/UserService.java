package com.unibuc.ro.service;

import com.unibuc.ro.model.UserDetailsDTO;

public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService {

    void save(UserDetailsDTO userDetails);

}