package com.example.ocpp.api;

import com.example.ocpp.domain.Transaction;
import com.example.ocpp.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired private TransactionRepo txRepo;

    @GetMapping("/energy")
    public Map<String,Object> energy(@RequestParam String from, @RequestParam String to){
        Instant f = Instant.parse(from); Instant t = Instant.parse(to);
        List<Transaction> txs = txRepo.findByStartTimeBetween(f,t);
        double kWh = txs.stream()
            .filter(tx -> tx.getStopMeterWh()!=null && tx.getStartMeterWh()!=null)
            .mapToDouble(tx -> (tx.getStopMeterWh() - tx.getStartMeterWh())/1000.0)
            .sum();
        Map<String,Object> res = new HashMap<>();
        res.put("totalKWh", kWh);
        res.put("count", txs.size());
        return res;
    }
}
