package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "ethernet_port")
public class EthernetPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}