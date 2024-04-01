package com.example.openschool3logger.service;

import com.example.openschool3logger.aop.LoggingAspect;
import com.example.openschool3logger.entity.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    @Autowired
    private UserService userService;
    @Autowired
    private LoggingAspect loggingAspect;

    @Test
    public void testCreateUserLogging() {
        userService.create(new UserEntity("John", "john@example.com"));
    }

}