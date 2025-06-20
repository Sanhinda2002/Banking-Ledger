package com.banking.ledger.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

// Entity class representing a transaction
@Entity
@Table (name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;   // Primary key of the transaction

    @NotNull(message = "Amount is required")
    private Double amount;  // Amount of the transaction

    @NotBlank(message = "Type is required")
    private String type; // Type of the transaction - credit, debit
    private String description;   // Description of the transaction
    private LocalDateTime timestamp;   // Timestamp when the transaction occurred

    // Many transactions can belong to one ledger
    @ManyToOne
    @JoinColumn(name = "ledger_id", nullable = false)
    private Ledger ledger;   // Ledger to which the transaction belongs

    // Getters
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

    // Setters
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

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
