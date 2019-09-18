package com.example.CosmeticsInciStore.repository;

import com.example.CosmeticsInciStore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
