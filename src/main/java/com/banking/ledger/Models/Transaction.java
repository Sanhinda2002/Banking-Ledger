package com.banking.ledger.Models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private double amount;
    private String type;
    private String description;
    private LocalDateTime timestamp;
    
}
