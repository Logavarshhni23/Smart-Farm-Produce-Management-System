package com.project.JavaProjectLeap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.JavaProjectLeap.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
