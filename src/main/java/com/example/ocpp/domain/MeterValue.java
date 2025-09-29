package com.example.ocpp.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity @Table(name="meter_value")
public class MeterValue {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChargingStation station;

    private Integer connectorId;
    private Integer transactionIdOcpp;
    private Instant timestamp;
    private Double valueWh;

    // getters/setters
    public void setStation(ChargingStation s){ this.station = s; }
    public void setConnectorId(Integer i){ this.connectorId = i; }
    public void setTransactionIdOcpp(Integer i){ this.transactionIdOcpp = i; }
    public void setTimestamp(Instant t){ this.timestamp = t; }
    public void setValueWh(Double v){ this.valueWh = v; }
}
