package com.jsp.pritam.dio.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String email;
    private int phNo;
    private String password;
    private String userRole;
    private LocalDate createAt;
    private LocalDate lastModifiedAt;
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