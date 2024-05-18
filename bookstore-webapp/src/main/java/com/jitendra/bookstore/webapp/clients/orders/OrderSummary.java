package com.jitendra.bookstore.webapp.clients.orders;

public record OrderSummary(String orderNumber, OrderStatus status) {}