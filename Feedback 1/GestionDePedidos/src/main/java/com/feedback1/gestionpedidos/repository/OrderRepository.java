package com.feedback1.gestionpedidos.repository;

import com.feedback1.gestionpedidos.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}