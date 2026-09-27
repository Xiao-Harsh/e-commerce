package com.soltrix.service;

import com.soltrix.dto.OrderRequest;
import com.soltrix.entity.Order;
import java.util.List;

public interface OrderService {
    Order createOrder(Long userId, OrderRequest orderRequest);
    List<Order> getOrdersByUserId(Long userId);
    Order getOrderById(Long userId, Long orderId);
    List<Order> getAllOrders();
    Order updateOrderStatus(Long orderId, String status);
}
