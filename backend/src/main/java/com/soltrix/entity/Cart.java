package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    private Long id;

    @JsonIgnore
    private User user;

    @Builder.Default
    private List<CartItem> cartItems = new ArrayList<>();
}
