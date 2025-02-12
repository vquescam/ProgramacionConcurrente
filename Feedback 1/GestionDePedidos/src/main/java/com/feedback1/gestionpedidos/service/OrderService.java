package com.feedback1.gestionpedidos.service;

import com.feedback1.gestionpedidos.model.Order;
import com.feedback1.gestionpedidos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public Iterable<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Order order) throws Exception {
        orderRepository.save(order);
        if (someConditionFails()) {
            throw new Exception("Simulated error");
        }
    }

    private boolean someConditionFails() {
        // Simula una condición que falla
        return true;
    }
}