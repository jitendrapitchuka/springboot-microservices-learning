package com.jitendra.orderservice.domain;

import com.jitendra.orderservice.domain.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByStatus(OrderStatus status);

    Optional<OrderEntity> findByOrderNumber(String orderNumber);

    default void updateOrderStatus(String orderNumber, OrderStatus status) {
        OrderEntity order = this.findByOrderNumber(orderNumber).orElseThrow();
        order.setStatus(status);
        this.save(order);
    }

}
