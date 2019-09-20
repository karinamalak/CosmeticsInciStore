package com.example.CosmeticsInciStore.repository;

import com.example.CosmeticsInciStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByName(String name);

    Product findByName(String name);

    List<Product> findAllByCategory(String category);
}
