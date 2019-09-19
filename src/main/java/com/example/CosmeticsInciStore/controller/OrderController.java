package com.example.CosmeticsInciStore.controller;

import com.example.CosmeticsInciStore.entity.Order;
import com.example.CosmeticsInciStore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/admin/orders", method = RequestMethod.GET)
    public List<Order> findAll(Model model){
        model.addAttribute("orders", orderService.findAll());
        return this.orderService.findAll();
    }

    @PostMapping(value = "/admin/delete_order")
    public String deleteOrder(@RequestParam(required = true) Long id, Model model){
        this.orderService.deleteOrderById(id);
        model.addAttribute("orders", this.orderService.findAll());
        return "admin/orders";
    }

    @PostMapping(value = "/admin/confirm_order")
    public String confirmOrder(@RequestParam(required = true) Order order, Model model){
        this.orderService.confirmOrder(order);
        model.addAttribute("orders", this.orderService.findAll());
        return "admin/orders";
    }


}
