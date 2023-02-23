package com.example.adam.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "servers")
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serverId;
    private String hostname;
    private String domain;
    private String fqdn;
    private String orgUnit;
    private String serialNumber;
    private String serverModel;
    private String dcMailcode;
    private Integer cores;
    private Integer ram;
    private String osMajVersion;
    private String timezone;
    private String patchGroup;
    private String ipAddress;
    private String ipMask;
    private String ipGateway;
    private String Id;
    private String serverProfile;
    private String releasePod;
    private Integer resourceId;
    private Integer activeRecord;
    private Integer appId;
    @OneToMany(mappedBy = "serverId", cascade = CascadeType.ALL)
    private List<VmElementsModel> vmElements;
    @OneToMany(mappedBy = "serverId", cascade = CascadeType.ALL)
    private List<PhysicalElementsModel> physicalElements;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<ServerIPsModel> secondaryIPs = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<FileSystemsModel> fileSystems = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<EthernetPortsModel> ethernetPorts = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<ServerHBAsModel> HBAs = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<InternalDisksModel> internalDisks = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "deployment_group_id", insertable = false)
    private DeploymentGroupModel deploymentGroup;
    public void setSecondaryIPs(List<ServerIPsModel> secondaryIPs) {
        this.secondaryIPs.addAll(secondaryIPs);
    }
    public void setFileSystems(List<FileSystemsModel> fileSystems) {
        this.fileSystems.addAll(fileSystems);
    }
    public void setEthernetPorts(List<EthernetPortsModel> ethernetPorts) {
        this.ethernetPorts.addAll(ethernetPorts);
    }
    public void setHBAs(List<ServerHBAsModel> HBAs) {
        this.HBAs.addAll(HBAs);
    }
    public void setInternalDisks(List<InternalDisksModel> internalDisks) {
        this.internalDisks.addAll(internalDisks);
    }
}



//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String host;
//
//    @Column(nullable = false)
//    private Integer port;

// constructors, getters, and setters
//}
