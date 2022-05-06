package com.entity.dto;

import com.entity.Customer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;


// ignore bo qua
@Builder
@Data
public class CustomerDto {
    private Long id;

    private String fullName;
    private String username;
    private String email;
    private String activationCode;
    private Boolean is_active;
    private Integer timeFailed;
    private Date createdAt;
    private Date updatedAt;
    private String phone;
}
