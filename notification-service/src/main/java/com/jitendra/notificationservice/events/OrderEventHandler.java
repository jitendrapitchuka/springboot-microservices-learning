package com.jitendra.notificationservice.events;

import com.jitendra.notificationservice.domain.NotificationService;
import com.jitendra.notificationservice.domain.OrderEventEntity;
import com.jitendra.notificationservice.domain.OrderEventRepository;
import com.jitendra.notificationservice.domain.models.OrderCancelledEvent;
import com.jitendra.notificationservice.domain.models.OrderCreatedEvent;
import com.jitendra.notificationservice.domain.models.OrderDeliveredEvent;
import com.jitendra.notificationservice.domain.models.OrderErrorEvent;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Component
public class OrderEventHandler {

    private static final Logger log= LoggerFactory.getLogger(OrderEventHandler.class);
    private final NotificationService notificationService;
    private final OrderEventRepository orderEventRepository;

    public OrderEventHandler(NotificationService notificationService,OrderEventRepository orderEventRepository) {
        this.notificationService = notificationService;
        this.orderEventRepository = orderEventRepository;
    }
    @RabbitListener(queues = "${notifications.new-orders-queue}")
    public void handle(OrderCreatedEvent event) {

        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderCreatedEvent with eventId: {}", event.eventId());
            return;
        }
        log.info("Received a OrderCreatedEvent with orderNumber:{}: ", event.orderNumber());
        notificationService.sendOrderCreatedNotification(event);
        var orderEvent = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEvent);

    }

    @RabbitListener(queues = "${notifications.delivered-orders-queue}")
    public void handle(OrderDeliveredEvent event) {

        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderDeliveredEvent with eventId: {}", event.eventId());
            return;
        }
        log.info("Received a OrderDeliveredEvent with orderNumber:{}: ", event.orderNumber());
        notificationService.sendOrderDeliveredNotification(event);
        var orderEvent = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEvent);


    }

    @RabbitListener(queues = "${notifications.cancelled-orders-queue}")
    public void handle(OrderCancelledEvent event) {

        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderCancelledEvent with eventId: {}", event.eventId());
            return;
        }
        notificationService.sendOrderCancelledNotification(event);
        log.info("Received a OrderCancelledEvent with orderNumber:{}: ", event.orderNumber());
        var orderEvent = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEvent);

    }

    @RabbitListener(queues = "${notifications.error-orders-queue}")
    public void handle(OrderErrorEvent event) {

        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("Received duplicate OrderErrorEvent with eventId: {}", event.eventId());
            return;
        }
        log.info("Received a OrderErrorEvent with orderNumber:{}: ", event.orderNumber());
        notificationService.sendOrderErrorEventNotification(event);
        OrderEventEntity orderEvent = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEvent);

    }
}
