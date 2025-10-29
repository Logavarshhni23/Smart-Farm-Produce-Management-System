package com.project.JavaProjectLeap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.JavaProjectLeap.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
    
}
