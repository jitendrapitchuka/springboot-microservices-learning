//package com.jitendra.orderservice.web.controllers;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//import com.jitendra.orderservice.web.controllers.RabbitMQDemoController.MyPayload;
//@Service
// class RabbitMQListener {
//
//    @RabbitListener(queues = "${orders.new-orders-queue}")
//    public void handleNewOrder(MyPayload payload){
//        System.out.println("new order: "+payload.content());
//    }
//}
