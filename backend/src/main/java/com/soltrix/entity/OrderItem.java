package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    private Long id;

    @JsonIgnore
    private Order order;

    private Product product;
    private Integer quantity;
    private String size;
    private Double price;
}
