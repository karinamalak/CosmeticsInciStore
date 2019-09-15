package com.example.CosmeticsInciStore.service;

import com.example.CosmeticsInciStore.entity.User;

import java.util.List;


public interface UserService {

    public User findUserByEmail(String email) ;
    public User saveUser(User user);
    public List<User> findAll();
}
