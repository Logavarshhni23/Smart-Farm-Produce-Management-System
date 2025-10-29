package com.project.JavaProjectLeap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.JavaProjectLeap.entity.Price;
import com.project.JavaProjectLeap.entity.Inventory;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{
    Price findByInventory(Inventory inventory);
}
