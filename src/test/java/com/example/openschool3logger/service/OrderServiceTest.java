package com.example.openschool3logger.service;

import com.example.openschool3logger.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateUserLogging() {
        orderService.create(new OrderEntity("Desc", "Status"));
    }
}