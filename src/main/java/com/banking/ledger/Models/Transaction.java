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

    private Ledger ledger;

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public Ledger getLedger() {
        return ledger;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLedger(Ledger ledger) {
        this.ledger = ledger;
    }
}
