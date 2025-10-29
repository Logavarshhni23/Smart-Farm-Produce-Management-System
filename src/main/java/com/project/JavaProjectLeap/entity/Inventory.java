package com.project.JavaProjectLeap.entity;

import jakarta.persistence.*;
import lombok.Data;
// import java.util.List;
import java.sql.Timestamp;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String farmerName;
    private String cropName;
    private String cropType;
    private int quantity;    
    private Timestamp addedTime;
}
