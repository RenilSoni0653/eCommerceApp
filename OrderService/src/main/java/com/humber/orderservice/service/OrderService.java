package com.humber.orderservice.service;

import com.humber.orderservice.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Orders placeNewOrder(Orders orders);
    public List<Orders> getAllOrders();
    public Boolean deleteOrder(Long orderId);
    public Optional<Orders> getOrderById(Long id);
}
