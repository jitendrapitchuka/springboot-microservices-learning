package com.jitendra.bookstore.webapp.clients.orders;



public record OrderConfirmationDTO(String orderNumber, OrderStatus status) {}