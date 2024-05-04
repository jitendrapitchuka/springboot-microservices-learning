package com.jitendra.orderservice.domain.models;

public enum OrderEventType {
    ORDER_CREATED,
    ORDER_DELIVERED,
    ORDER_CANCELLED,
    ORDER_PROCESSING_FAILED
}