package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "physical_elements")
public class PhysicalElementsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server serverId;
}
