package com.example.adam.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "design_revisions")
public class DesignModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designId;
    private String designVersion;
    private String designName;
    private Integer appImpactId;
    private Integer appId;
    private String designStatus="Future";
    private String designBase;
    private String designApproval="Draft";

    private String approvedBy;
    private String approvalStatus;
    private Boolean isApproved;
    private Boolean level1Approval = false;
    private Boolean level2Approval = false;
    private Boolean level3Approval = false;

}