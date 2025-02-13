package smga.pedidos.service;

import smga.pedidos.model.Order;
import smga.pedidos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Order order) throws Exception {
        orderRepository.save(order);
        if (someConditionFails()) {
            throw new Exception("Simulated error");
        }
    }

    private boolean someConditionFails() {
        // Lógica de ejemplo para la simulación de error
        return false;
    }
}