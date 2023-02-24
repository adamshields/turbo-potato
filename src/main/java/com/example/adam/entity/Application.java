package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ait")
    private String ait;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "portfolio_lead_id", referencedColumnName = "employee_id")
    private UsersModel portfolioLead;
}
