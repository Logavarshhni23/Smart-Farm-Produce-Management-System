package com.project.JavaProjectLeap.controller;

import com.project.JavaProjectLeap.service.OrderService;
import com.project.JavaProjectLeap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.JavaProjectLeap.entity.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeorder(order);
    }

    @GetMapping("/buyes/{buyerId}")
    public List<Order> getOrderByBuyer(@PathVariable Long buyerId){
        User buyer = userService.getUserById(buyerId);
        return orderService.getOrderByBuyer(buyer);
    }

    @GetMapping("/cropName/{cropName}")
    public List<Order> getOrderByInventory(@PathVariable String cropName){
        return orderService.getOrderByInventory(cropName);
    }

    @PutMapping("/{id}/status")
    public Order updateOrder(@PathVariable Long id, @RequestParam String status){
        return orderService.updateOrder(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }





}
