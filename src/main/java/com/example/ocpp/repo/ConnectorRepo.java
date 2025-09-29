package com.example.ocpp.repo;
import com.example.ocpp.domain.Connector;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface ConnectorRepo extends JpaRepository<Connector, Long> {
    Optional<Connector> findByStation_StationIdAndConnectorId(String stationId, Integer connectorId);
}
