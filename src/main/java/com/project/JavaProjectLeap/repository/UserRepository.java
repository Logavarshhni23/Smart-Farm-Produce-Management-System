package com.project.JavaProjectLeap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.JavaProjectLeap.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
