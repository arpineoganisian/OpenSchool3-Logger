package com.example.openschool3logger.service;

import com.example.openschool3logger.entity.UserEntity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    private static Scanner scanner;
    private static final File file = new File("src/test/testLog/testLoggerApp.log");

    @BeforeAll
    public static void setUp() throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    @AfterAll
    public static void tearDown() {
        scanner.close();
        Assertions.assertTrue(file.delete());
    }

    @Test
    public void testCreateUserLogging() {
        UserEntity user = new UserEntity("John", "john@email.com");
        userService.create(user);

        String logBefore = "INFO c.e.o.a.LoggingAspect [main] before execution(void com.example.openschool3logger.service.UserService.create(UserEntity)), args=[User{id=null, name='John', email='john@email.com'}]";
        Assertions.assertTrue(findLogLine(logBefore));

        String logAfter = "INFO c.e.o.a.LoggingAspect [main] after execution(void com.example.openschool3logger.service.UserService.create(UserEntity))";
        Assertions.assertTrue(findLogLine(logAfter));
    }

    private boolean findLogLine(String logLine) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(logLine)) {
                return true;
            }
        }
        return false;
    }
}