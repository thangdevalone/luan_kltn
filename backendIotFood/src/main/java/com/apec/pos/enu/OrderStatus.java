package com.apec.pos.enu;

public enum OrderStatus {
    PENDING("Pending"),     // Đang chờ xử lý
    PROCESSING("Processing"), // Đang xử lý
    DELIVERED("Delivered"), // Đã giao hàng
    CANCELED("Canceled");   // Đã hủy

    private final String label;

    private OrderStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
