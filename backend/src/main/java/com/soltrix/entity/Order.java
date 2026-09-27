package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    private Long id;
    private User user;
    private Double totalPrice;
    private String status;

    @Builder.Default
    private String paymentMethod = "CASH_ON_DELIVERY";

    private String shippingAddress;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    private List<OrderItem> orderItems = new ArrayList<>();

    // ==========================================
    // Backward Compatibility Getters for Frontend
    // ==========================================

    @JsonProperty("totalAmount")
    public Double getTotalAmount() {
        return totalPrice;
    }

    @JsonProperty("orderDate")
    public LocalDateTime getOrderDate() {
        return createdAt;
    }
}
