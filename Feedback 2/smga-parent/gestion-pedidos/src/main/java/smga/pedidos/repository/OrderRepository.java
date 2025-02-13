package smga.pedidos.repository;

import smga.pedidos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Ejemplo de repositorio JPA para la entidad Order
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Métodos de consulta adicionales, si se necesitan, van aquí
}