package com.humber.orderservice.controller;

import com.humber.orderservice.entity.Orders;
import com.humber.orderservice.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    private final OrderServiceImpl orderServiceImpl;

    public OrderController(OrderServiceImpl orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<Orders> placeNewOrder(@RequestBody Orders orders) {
        log.info("OrderController :: placeNewOrder");
        return ResponseEntity.ok(orderServiceImpl.placeNewOrder(orders));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Orders>> getAllOrderDetails() {
        log.info("OrderController :: getAllOrderDetails");
        return ResponseEntity.ok(orderServiceImpl.getAllOrders());
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        log.info("OrderController :: deleteOrder");
        orderServiceImpl.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully.");
    }
}
