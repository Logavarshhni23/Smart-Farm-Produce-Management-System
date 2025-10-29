package com.project.JavaProjectLeap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.JavaProjectLeap.entity.Inventory;
import java.util.List;
import com.project.JavaProjectLeap.entity.User;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
    List<Inventory> findByUser(User user);
}
