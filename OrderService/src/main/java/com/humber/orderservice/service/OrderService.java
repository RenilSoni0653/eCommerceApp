package com.humber.orderservice.service;

import com.humber.orderservice.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order placeNewOrder(Order order);
    public List<Order> getAllOrders();
    public Boolean deleteOrder(Long orderId);
    public Optional<Order> getOrderById(Long id);
}
