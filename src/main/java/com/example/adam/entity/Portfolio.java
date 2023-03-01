package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "portfolio_name")
    private String portfolioName;

    @Column(name = "portfolio_lead")
    private String portfolioLead;

    // constructors, getters, and setters
}
