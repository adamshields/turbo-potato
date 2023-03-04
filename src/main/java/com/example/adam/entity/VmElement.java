//package com.example.adam.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//@Data
//@Entity
//@Table(name = "vm_element")
//public class VmElement {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "server_id")
//    private Server serverId;
//
//    private String resourcePool;
//
//
//}