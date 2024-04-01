package com.example.openschool3logger.service;

import com.example.openschool3logger.entity.UserEntity;
import com.example.openschool3logger.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void create(UserEntity user) {
        userRepository.save(user);
    }

    public void update(UserEntity user, Long id) {
        user.setId(id);
        userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
