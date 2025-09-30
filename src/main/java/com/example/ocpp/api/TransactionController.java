package com.example.ocpp.api;

import com.example.ocpp.domain.Transaction;
import com.example.ocpp.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.util.*;

@RestController
@RequestMapping("/api/transactions")
//@ConditionalOnProperty(name = "database.enabled", havingValue = "true", matchIfMissing = false)
public class TransactionController {
    @Autowired private TransactionRepo repo;

    @GetMapping
    public List<Transaction> range(@RequestParam String from, @RequestParam String to){
        Instant f = Instant.parse(from); Instant t = Instant.parse(to);
        return repo.findByStartTimeBetween(f,t);
    }
}
