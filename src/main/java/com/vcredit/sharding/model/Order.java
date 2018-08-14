package com.vcredit.sharding.model;

public class Order {
    private Long orderId;

    private Integer userId;

    private String status;

    public Order(Long orderId, Integer userId, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}