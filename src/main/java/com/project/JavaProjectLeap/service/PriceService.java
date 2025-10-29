package com.project.JavaProjectLeap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.JavaProjectLeap.repository.PriceRepository;
import com.project.JavaProjectLeap.entity.Price;
import com.project.JavaProjectLeap.entity.Inventory;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public Price addPrice(Price price) {
        return priceRepository.save(price);
    }

    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Price getPriceByInventory(Inventory inventory) {
        return priceRepository.findByInventory(inventory);

    }

    public Price updatePrice(Long id, Price updatedPrice) {
        Price price = priceRepository.findById(id).orElse(null);
        if (price != null) {
            price.setPricePerUnit(updatedPrice.getPricePerUnit());
            price.setUpdatedTime(updatedPrice.getUpdatedTime());
            return priceRepository.save(price);
        }
        return null;
    }

    public void deletePrice(Long id) {
        priceRepository.deleteById(id);
    }

}
