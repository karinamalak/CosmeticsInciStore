package com.example.CosmeticsInciStore.service;

import com.example.CosmeticsInciStore.entity.Order;
import com.example.CosmeticsInciStore.entity.Role;
import com.example.CosmeticsInciStore.entity.User;
import com.example.CosmeticsInciStore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

     private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order makeOrder (Order order) {
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void deleteOrderById(Long id) {
        this.orderRepository.deleteById(id);
    }

    @Transactional
    public void confirmOrder(Order order) {
        this.orderRepository.save(order);
    }

    @Transactional
    public void sumOfOrder() {
        this.orderRepository.count();
    }


}
