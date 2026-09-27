package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImage {

    private Long id;

    @JsonIgnore
    private Product product;

    private String imageUrl;
}
