package com.example.CosmeticsInciStore;

import com.example.CosmeticsInciStore.entity.User;
import com.example.CosmeticsInciStore.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CosmeticsInciStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosmeticsInciStoreApplication.class, args);

    }

}
