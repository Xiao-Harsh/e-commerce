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
public class Category {

    private Long id;
    private String name;

    @Builder.Default
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
}
