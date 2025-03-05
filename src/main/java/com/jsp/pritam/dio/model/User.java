package com.jsp.pritam.dio.model;

import com.jsp.pritam.dio.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userid;

    @Column(name = "user_name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "ph_no")
    private String phno;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userrole;

    @Column(name = "created_at")
    private LocalDateTime createdat;

    @Column(name = "last_modified_at")
    private LocalDateTime lastmodifiedat;
}
/*
Inheritance Type

Joined
Singele_Table
Table_Per_Class
-------------------
what?
when?
why?
 */