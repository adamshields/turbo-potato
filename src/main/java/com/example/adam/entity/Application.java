package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ait")
    private String ait;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @ManyToMany(mappedBy = "applications")
    private List<Design> designs = new ArrayList<>();

    public List<Design> getDesigns() {
        return designs;
    }

    @OneToOne
    @JoinColumn(name = "portfolio_lead_id", referencedColumnName = "employee_id")
    private UsersModel portfolioLead;
}
