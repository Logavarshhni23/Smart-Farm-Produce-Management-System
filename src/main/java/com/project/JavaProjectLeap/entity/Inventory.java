package com.project.JavaProjectLeap.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cropName;
    private String cropType;
    private int quantity;    
    private Timestamp addedTime;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
}
