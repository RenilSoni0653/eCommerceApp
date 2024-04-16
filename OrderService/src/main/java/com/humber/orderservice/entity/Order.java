package com.humber.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime orderDate;
    private OrderStatus Status;
    private Float orderTotal;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
    private List<ProductDetail> productDetailList = new ArrayList<>();
}
