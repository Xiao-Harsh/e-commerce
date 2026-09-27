package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String email;

    @JsonIgnore
    private String password;

    private String name;
    private Role role;
    private String phone;
    private String address;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
