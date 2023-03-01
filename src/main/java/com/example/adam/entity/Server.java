package com.example.adam.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "server")
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
    private String clusterId;
    private String serverProfile;
    private String releasePod;
    private Integer resourceId;
    private Integer activeRecord;
    private Integer appId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "design_id")
    private Design design;

    @OneToMany(mappedBy = "serverId", cascade = CascadeType.ALL)
    private List<VmElement> vmElements;
    @OneToMany(mappedBy = "serverId", cascade = CascadeType.ALL)
    private List<PhysicalElement> physicalElements;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<ServerIP> secondaryIPs = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<FileSystem> fileSystems = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<EthernetPort> ethernetPorts = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<ServerHBA> HBAs = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "serverId")
    private List<InternalDisk> internalDisks = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "deployment_group_id", insertable = false)
    private DeploymentGroup deploymentGroup;
    public void setSecondaryIPs(List<ServerIP> secondaryIPs) {
        this.secondaryIPs.addAll(secondaryIPs);
    }
    public void setFileSystems(List<FileSystem> fileSystems) {
        this.fileSystems.addAll(fileSystems);
    }
    public void setEthernetPorts(List<EthernetPort> ethernetPorts) {
        this.ethernetPorts.addAll(ethernetPorts);
    }
    public void setHBAs(List<ServerHBA> HBAs) {
        this.HBAs.addAll(HBAs);
    }
    public void setInternalDisks(List<InternalDisk> internalDisks) {
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
