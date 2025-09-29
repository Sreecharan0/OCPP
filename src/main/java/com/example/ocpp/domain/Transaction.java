package com.example.ocpp.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity @Table(name="tx")
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChargingStation station;

    private Integer connectorId;
    private Integer transactionIdOcpp;

    @Column(nullable=false)
    private String idTag;

    private Instant startTime;
    private Instant stopTime;
    private Double startMeterWh;
    private Double stopMeterWh;

    @Enumerated(EnumType.STRING)
    private State state;

    @Version
    private Long version;

    public enum State { STARTED, STOPPED, FAILED }

    // builder-like factory for simplicity
    public static Transaction of(ChargingStation st, Integer connId, Integer txId, String idTag, Instant start, Double meterStart, State stt){
        Transaction t = new Transaction();
        t.station = st; t.connectorId = connId; t.transactionIdOcpp = txId; t.idTag = idTag; t.startTime = start; t.startMeterWh = meterStart; t.state = stt;
        return t;
    }

    // getters/setters
    public Integer getTransactionIdOcpp(){ return transactionIdOcpp; }
    public void setStopTime(Instant i){ this.stopTime = i; }
    public void setStopMeterWh(Double d){ this.stopMeterWh = d; }
    public Double getStopMeterWh(){ return stopMeterWh; }
    public Double getStartMeterWh(){ return startMeterWh; }
    public void setState(State s){ this.state = s; }
}
