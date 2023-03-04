package com.example.adam.entity;
import lombok.Data;
import javax.persistence.*;

/**
 * Represents an approval model for a design revision.
 *
 * This class stores information about the approvals for a design revision, including whether
 * it has been fully approved, and the usernames of the users who have approved it at each
 * approval level. The approval levels are represented by the level1Approval, level2Approval,
 * and level3Approval fields. If an approval level has not been completed, the corresponding
 * field should be left blank.
 *
 * The fullyApproved field indicates whether the design revision has been fully approved. If
 * this field is true, it means that all three approval levels have been completed.
 *
 */
@Data
@Entity
@Table(name = "design_approval")
public class ApprovalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "fully_approved", columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean fullyApproved;
    @Column(name = "level_1_approval", length = 300, nullable = false)
    private String level1Approval; // saves username
    @Column(name = "level_2_approval", length = 300, nullable = false)
    private String level2Approval;
    @Column(name = "level_3_approval", length = 300, nullable = false)
    private String level3Approval;


}

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "level_1_approval_user_id")
//    private UsersModel level1ApprovalUser;
//
//    @Column(name = "level_1_approval", length = 300)
//    private String level1Approval;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "level_2_approval_user_id")
//    private UsersModel level2ApprovalUser;
//
//    @Column(name = "level_2_approval", length = 300)
//    private String level2Approval;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "level_3_approval_user_id")
//    private UsersModel level3ApprovalUser;
//
//    @Column(name = "level_3_approval", length = 300)
//    private String level3Approval;
//
//    @Column(name = "is_fully_approved", columnDefinition = "BOOLEAN DEFAULT false")
//    private Boolean isFullyApproved;
////    @OneToOne(mappedBy = "approvalModel", cascade = CascadeType.ALL)
////    private Design design;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "design_id", referencedColumnName = "designId")
//    private Design design;


//}

//@Data
//@Entity
//@Table(name = "design_approval")
//public class ApprovalModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "approvalId")
//    private Integer approvalId;
//    @Column(name = "is_fully_approved", columnDefinition = "BOOLEAN DEFAULT false" )
//    private Boolean isFullyApproved;
//
//    @Column(name = "level_1_approval", length = 300, nullable = false)
//    private String level1Approval; // saves username
//    @Column(name = "level_2_approval", length = 300, nullable = false)
//    private String level2Approval;
//    @Column(name = "level_3_approval", length = 300, nullable = false)
//    private String level3Approval;
//}




//
//import io.swagger.v3.oas.annotations.media.Schema;
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import java.util.HashSet;
//import java.util.Set;
//
//@Data
//@Entity
//@Table(name = "design_revisions")
//public class Design {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Schema(description = "Design ID")
//
//    private Integer designId;
//    private String designVersion;
//    @NotBlank(message = "Design Name is required")
//    @Schema(description = "Design name")
//    private String designName;
//    private Integer appImpactId;
//    private Integer appId;
//    private String designStatus="Future";
//    private String designBase;
//    private String designApproval="Draft";
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "design_application",
//            joinColumns = @JoinColumn(name = "design_id"),
//            inverseJoinColumns = @JoinColumn(name = "application_id"))
//    private Set<Application> applications = new HashSet<>();
//
//
//    @OneToMany(mappedBy = "design", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Server> servers = new HashSet<>();
//
//    private String approvedBy;
//    private String approvalStatus;
//    private Boolean isApproved;
//    private Boolean level1Approval = false;
//    private Boolean level2Approval = false;
//    private Boolean level3Approval = false;
//
//}