package com.example.openschool3logger;

import com.example.openschool3logger.entity.OrderEntity;
import com.example.openschool3logger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerApplication implements CommandLineRunner {

    private final OrderService orderService;

    @Autowired
    public LoggerApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        OrderEntity order = new OrderEntity("Desc", "Status");
        orderService.create(order);
    }

    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
    }
}
