package com.example.adam.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vm_elements_model")
public class VmElementsModel {
    @ManyToOne
    @JoinColumn(name = "server_server_id")
    private Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}