package com.soltrix.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private Long id;

    @JsonIgnore
    private User user;

    private String streetAddress;
    private String city;
    private String state;
    private String pincode;
}
