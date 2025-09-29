package com.example.ocpp.repo;
import com.example.ocpp.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.*;
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByStation_StationIdAndTransactionIdOcpp(String stationId, Integer txId);
    List<Transaction> findByStartTimeBetween(Instant from, Instant to);
}
