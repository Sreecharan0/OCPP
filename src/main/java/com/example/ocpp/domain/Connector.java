package com.example.ocpp.domain;

import jakarta.persistence.*;

@Entity @Table(name="connector", uniqueConstraints = @UniqueConstraint(columnNames = {"station_id", "connector_id"}))
public class Connector {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="station_id")
    private ChargingStation station;

    @Column(name="connector_id", nullable = false)
    private Integer connectorId;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { Available, Occupied, Faulted, Unavailable }

    // getters/setters
    public Long getId(){ return id; }
    public ChargingStation getStation(){ return station; }
    public void setStation(ChargingStation s){ this.station = s; }
    public Integer getConnectorId(){ return connectorId; }
    public void setConnectorId(Integer i){ this.connectorId = i; }
    public Status getStatus(){ return status; }
    public void setStatus(Status s){ this.status = s; }
}
