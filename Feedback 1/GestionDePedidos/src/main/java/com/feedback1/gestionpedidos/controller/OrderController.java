package com.feedback1.gestionpedidos.controller;

import com.feedback1.gestionpedidos.model.Order;
import com.feedback1.gestionpedidos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public Iterable<Order> findAllOrders() {
        return orderService.findAllOrders();
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody Order order) throws Exception {
        order.setId(id);
        orderService.updateOrder(order);
    }
}