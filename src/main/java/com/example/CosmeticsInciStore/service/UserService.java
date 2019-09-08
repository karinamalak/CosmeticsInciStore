package com.example.CosmeticsInciStore.service;

import com.example.CosmeticsInciStore.entity.User;


public interface UserService {

    public User findUserByEmail(String email) ;
    public User saveUser(User user);
}
