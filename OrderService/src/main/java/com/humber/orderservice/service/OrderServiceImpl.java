package com.humber.orderservice.service;

import com.humber.orderservice.common.Constants;
import com.humber.orderservice.entity.Order;
import com.humber.orderservice.exception.OrderNotFoundException;
import com.humber.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository OrderRepository, OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order placeNewOrder(Order order) {
        log.info("OrderServiceImpl :: placeNewOrder");
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        log.info("OrderServiceImpl :: getAllOrders - START");
        List<Order> orders = orderRepository.findAll();
        if(orders.isEmpty()) {
            throw new OrderNotFoundException(Constants.ORDER_NOT_FOUND_MESSAGE);
        }
        log.info("OrderServiceImpl :: getAllOrders - END");
        return orders;
    }

    public Boolean deleteOrder(Long orderId) {
        log.info("OrderServiceImpl :: deleteOrder - START");
        Optional<Order> order = getOrderById(orderId);
        if (order.isPresent()) {
            orderRepository.save(order.get());
        } else {
            throw new OrderNotFoundException(Constants.ORDER_NOT_FOUND_MESSAGE);
        }
        log.info("OrderServiceImpl :: deleteOrder - END");
        return true;
    }

    public Optional<Order> getOrderById(Long id) {
        log.info("OrderServiceImpl :: getOrderById - START");
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty()) {
            throw new OrderNotFoundException(Constants.ORDER_NOT_FOUND_MESSAGE);
        }
        log.info("OrderServiceImpl :: getOrderById - END");
        return order;
    }
}
