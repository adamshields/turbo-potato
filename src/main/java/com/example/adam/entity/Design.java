package com.example.adam.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a design revision for a product.
 *
 * This class stores information about a design revision, including its ID, version number,
 * name, and whether it can be edited. It also includes a relationship to the ApprovalModel
 * class, which tracks the approvals for the design revision.
 *
 */
@Data
@Entity
@Table(name = "design_revisions")
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Design ID")
    private Long designId;

    private String designVersion;

    @Column(name = "design_name", length = 300, nullable = false)
    private String designName;

    @Column(name = "is_editable", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isEditable;


    // Ties to Approvals
    @ManyToOne
    @JoinColumn(name = "id")
    private ApprovalModel approvalModel;

    // Ties to Designs
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "design_application",
            joinColumns = @JoinColumn(name = "design_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id"))
    private Set<Application> applications = new HashSet<>();
}

//    @OneToOne(mappedBy = "design", cascade = CascadeType.ALL)
//    private ApprovalModel approvalModel;

//    public ApprovalModel getApprovalModel() {
//        return approvalModel;
//    }

//    private boolean isFullyApproved;

//    @OneToOne(mappedBy = "design")
//    private ApprovalModel approvalModel;

//    // getters and setters
//    public boolean isFullyApproved() {
//        return isFullyApproved;
//    }
//
//    public void setFullyApproved(boolean isFullyApproved) {
//        this.isFullyApproved = isFullyApproved;
//    }
//}

////    Servers can be part of
//    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Server> servers = new HashSet<>();
//    @Column(name = "app_impact_id", nullable = false)
//    private Integer appImpactId;
//    @Column(name = "app_id", length = 300, nullable = false)
//    private Integer appId;
//    private String designStatus="Future";
//    private String designBase;
// Ties Design to Application
//@ManyToMany(fetch = FetchType.LAZY)
//@JoinTable(name = "design_application",
//        joinColumns = @JoinColumn(name = "design_id"),
//        inverseJoinColumns = @JoinColumn(name = "application_id"))
//private Set<Application> applications = new HashSet<>();
