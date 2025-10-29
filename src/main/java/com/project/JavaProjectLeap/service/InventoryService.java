package com.project.JavaProjectLeap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.JavaProjectLeap.repository.InventoryRepository;
import com.project.JavaProjectLeap.entity.Inventory;
import com.project.JavaProjectLeap.entity.User;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory createInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getInventoryByUser(User user){
        return inventoryRepository.findByUser(user);
    }

    public Inventory getInventoryById(Long id){
        return inventoryRepository.findById(id).orElse(null);
    }

    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }

    public Inventory updateInventory(Long id, Inventory updatedInventory){
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        if(inventory != null){
            inventory.setCropName(updatedInventory.getCropName());
            inventory.setCropType(updatedInventory.getCropType());
            inventory.setQuantity(updatedInventory.getQuantity());
            return inventoryRepository.save(inventory);
        }
        return null;
    }

    public void deleteInventory(Long id){
        inventoryRepository.deleteById(id);
    }
    
}
