package com.project.JavaProjectLeap.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Inventory> inventoryList;

}
