package com.example.CosmeticsInciStore.repository;

import com.example.CosmeticsInciStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
