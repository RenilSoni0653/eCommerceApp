package com.humber.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @NotBlank(message = "Name can't be empty.")
    private String name;
    @NotBlank(message = "Description can't be empty.")
    private String description;
    @Min(value = 0)
    @NotNull(message = "Price can't be null.")
    private Float price;
    @NotNull(message = "ImageId can't be null.")
    private Long imageId;
    private Boolean isAvailable = true;
    private Boolean isDeleted = false;
    @NotNull(message = "Quantity can't be null.")
    private Integer quantity;
    @JsonBackReference
    @ManyToOne
    private Order order;
}
