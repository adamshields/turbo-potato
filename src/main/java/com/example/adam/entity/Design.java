package com.example.adam.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "design_revisions")
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Design ID")

    private Integer designId;
    private String designVersion;
    @NotBlank(message = "Design Name is required")
    @Schema(description = "Design name")
    private String designName;
    private Integer appImpactId;
    private Integer appId;
    private String designStatus="Future";
    private String designBase;
    private String designApproval="Draft";

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "design_application",
            joinColumns = @JoinColumn(name = "design_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id"))
    private Set<Application> applications = new HashSet<>();


    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Server> servers = new HashSet<>();

    private String approvedBy;
    private String approvalStatus;
    private Boolean isApproved;
    private Boolean level1Approval = false;
    private Boolean level2Approval = false;
    private Boolean level3Approval = false;

}