package com.example.ocpp.api;

import com.example.ocpp.domain.ChargingStation;
import com.example.ocpp.repo.ChargingStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/stations")
public class StationController {
    @Autowired private ChargingStationRepo repo;

    @GetMapping
    public List<ChargingStation> list(){ return repo.findAll(); }

    @GetMapping("/{stationId}")
    public ChargingStation one(@PathVariable String stationId){
        return repo.findByStationId(stationId).orElseThrow();
    }
}
