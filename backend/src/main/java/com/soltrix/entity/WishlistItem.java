package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishlistItem {

    private Long id;

    @JsonIgnore
    private User user;

    private Product product;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
