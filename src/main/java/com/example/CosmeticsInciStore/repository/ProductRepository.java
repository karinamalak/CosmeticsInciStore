package com.example.CosmeticsInciStore.repository;

import com.example.CosmeticsInciStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
