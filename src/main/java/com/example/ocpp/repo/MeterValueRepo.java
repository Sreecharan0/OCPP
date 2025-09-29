package com.example.ocpp.repo;
import com.example.ocpp.domain.MeterValue;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface MeterValueRepo extends JpaRepository<MeterValue, Long> {
    List<MeterValue> findByStation_StationIdAndTransactionIdOcpp(String stationId, Integer txId);
}
