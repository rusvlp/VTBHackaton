package com.example.demo.services;

import com.example.demo.entites.Image;
import com.example.demo.entites.User;
import com.example.demo.enums.Role;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User getUserByPrincipal(Principal p){
        if (p == null) return new User();
        return userRepository.findUserByUsername(p.getName());
    }

    public boolean isUserExist(String username){
        if (userRepository.findUserByUsername(username) == null){
            return false;
        } return true;
    }

    public void addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        userRepository.save(user);
    }

    public void setAvatar(Image image, User user){
        user.setAvatar(image);
        userRepository.save(user);
    }
}
