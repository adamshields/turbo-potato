package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "file_system")
public class FileSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "fs_mount", length = 45, nullable = true)
    private String fsMount;

    @Column(name = "fs_gb", nullable = true)
    private Double fsGb;

    @Column(name = "fs_disk_type", length = 45, nullable = true)
    private String fsDiskType;

    @Column(name = "fs_owner", length = 45, nullable = true)
    private String fsOwner;

    @Column(name = "fs_group", length = 45, nullable = true)
    private String fsGroup;

    @Column(name = "fs_permissions", length = 45, nullable = true)
    private String fsPermissions;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serverId")
    private Server server;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storageId")
    private MidRangeStorage midRangeStorage;
}