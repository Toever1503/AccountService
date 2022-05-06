package com.entity.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerModel {
    private Long id;

    private String fullName;

    private String username;

    private String password;

    private String email;

    private Boolean isActive;

    private String phone;

    private String imageProfile; // add later
}
