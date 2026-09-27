package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {

    private Long id;

    @JsonIgnore
    private Cart cart;

    private Product product;
    private Integer quantity;
    private String selectedSize;

    // ==========================================
    // Backward Compatibility Getters/Setters for Frontend
    // ==========================================

    @JsonProperty("size")
    public String getSize() {
        return selectedSize;
    }

    public void setSize(String size) {
        this.selectedSize = size;
    }
}
