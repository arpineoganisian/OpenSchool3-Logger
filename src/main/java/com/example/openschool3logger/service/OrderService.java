package com.example.openschool3logger.service;

import com.example.openschool3logger.entity.OrderEntity;
import com.example.openschool3logger.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public OrderEntity findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void create(OrderEntity order) {
        orderRepository.save(order);
    }

    public void update(OrderEntity order, Long id) {
        order.setId(id);
        orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
