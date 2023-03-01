package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "server_hba")
public class ServerHBA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}