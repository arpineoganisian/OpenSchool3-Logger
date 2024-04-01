package com.example.openschool3logger.repository;

import com.example.openschool3logger.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
