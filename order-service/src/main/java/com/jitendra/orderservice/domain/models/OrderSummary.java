package com.jitendra.orderservice.domain.models;

public record OrderSummary(String orderNumber, OrderStatus status) {}