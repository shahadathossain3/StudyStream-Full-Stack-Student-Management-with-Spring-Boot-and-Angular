package com.example.springbootstudentmanagement.model;

import javax.persistence.*;

@Entity
@Table
public class notices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notice;
}
