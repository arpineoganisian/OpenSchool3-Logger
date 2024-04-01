package com.example.openschool3logger.service;

import com.example.openschool3logger.entity.OrderEntity;
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
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

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
        OrderEntity order = new OrderEntity("Book", "Delivered");
        orderService.create(order);

        String logBefore = "INFO c.e.o.a.LoggingAspect [main] before execution(void com.example.openschool3logger.service.OrderService.create(OrderEntity)), args=[Order{id=null, description='Book', status='Delivered'}]";
        Assertions.assertTrue(findLogLine(logBefore));

        String logAfter = "INFO c.e.o.a.LoggingAspect [main] after execution(void com.example.openschool3logger.service.OrderService.create(OrderEntity))";
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