package com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "activation_code") // activation code kich hoat tai khoan
    private String activationCode;

    @Column(name = "is_active") // disable or enable account
    private Boolean isActive;

    @Column(name = "time_failed") // so lan dang nhap sai
    private Integer timeFailed;

    @Column(name = "status")
    private Boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "phone")
    private String phone;

    @Column(name = "time_locked") // thoi gian khoa hien tai
    private Long timeLocked;

    @Column(name = "day_locked_numbers") // so ngay khoa
    private Integer dayLockedNumbers;

    @Column(name = "image_profile")
    private String imageProfile;
}
