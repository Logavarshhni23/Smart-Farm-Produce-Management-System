package com.project.JavaProjectLeap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.JavaProjectLeap.repository.UserRepository;
import com.project.JavaProjectLeap.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUserByRole(String role){
        return userRepository.findByRole(role);
    }
    
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User login(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user!=null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public User updateUser(Long id, User updatedUser){
        User user = userRepository.findById(id).orElse(null);
        if(user!=null){
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
