package com.project.JavaProjectLeap.controller;

import com.project.JavaProjectLeap.service.InventoryService;
import com.project.JavaProjectLeap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.JavaProjectLeap.entity.*;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private UserService userService;

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory){
        return inventoryService.createInventory(inventory);
    }

    @GetMapping("/user/{userId}")
    public List<Inventory> getInventoryByUser(@PathVariable Long id){
        User user = userService.getUserById(id);
        return inventoryService.getInventoryByUser(user);
    }

    @GetMapping
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();
    }
    
    @PutMapping
    public Inventory updateInventory(@PathVariable Long id , @RequestBody Inventory updatedInventory){
        return inventoryService.updateInventory(id, updatedInventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id){
        inventoryService.deleteInventory(id);
    }
}
