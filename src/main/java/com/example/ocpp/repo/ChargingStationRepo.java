package com.example.ocpp.repo;
import com.example.ocpp.domain.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface ChargingStationRepo extends JpaRepository<ChargingStation, Long> {
    Optional<ChargingStation> findByStationId(String stationId);
}
