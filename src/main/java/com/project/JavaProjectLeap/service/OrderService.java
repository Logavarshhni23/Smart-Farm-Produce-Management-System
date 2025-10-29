package com.project.JavaProjectLeap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.JavaProjectLeap.repository.OrderRepository;
import com.project.JavaProjectLeap.entity.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
     
    public Order placeorder(Order order){
        return orderRepository.save(order);
    }

    public List<Order> getOrderByBuyer(User buyer){
        return orderRepository.findByBuyer(buyer);
    }

    public List<Order> getOrderByInventory(String cropName){
        return orderRepository.findByInventory(cropName);
    }

    public Order updateOrder(Long id,String status){
        Order order = orderRepository.findById(id).orElse(null);
        if(order!=null){
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }

}
