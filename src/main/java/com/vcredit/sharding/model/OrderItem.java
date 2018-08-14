package com.vcredit.sharding.model;

public class OrderItem {
    private Long orderItemId;

    private Long orderId;

    private Integer userId;

    public OrderItem(Long orderItemId, Long orderId, Integer userId) {
        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.userId = userId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}