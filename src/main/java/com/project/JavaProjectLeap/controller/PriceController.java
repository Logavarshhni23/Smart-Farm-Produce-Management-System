package com.project.JavaProjectLeap.controller;

import com.project.JavaProjectLeap.service.PriceService;
import com.project.JavaProjectLeap.service.InventoryService;
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
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public Price addPrice(@RequestBody Price price){
        return priceService.addPrice(price);
    }

    @GetMapping
    public List<Price> getAllPrices(){
        return priceService.getAllPrices();
    }

    @GetMapping("/inventory/{inventoryId}")
    public Price getPriceByInventory(@PathVariable Long inventoryId){
        Inventory inventory = inventoryService.getInventoryById(inventoryId);
        return priceService.getPriceByInventory(inventory);
    }

    @PutMapping("/{id}")
    public Price updatePrice(@PathVariable Long id, @RequestBody Price price){
        return priceService.updatePrice(id, price);
    }

    @DeleteMapping("/{id}")
    public void deletePrice(@PathVariable Long id){
        priceService.deletePrice(id);
    }

    
    
}
