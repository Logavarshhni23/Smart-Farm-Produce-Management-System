package com.project.JavaProjectLeap.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
public class Price {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private double pricePerUnit;
    private Timestamp updatedTime;

    @OneToOne
    @JoinColumn(name="inventoryId")
    private Inventory inventory;
    
}
