package com.banking.ledger.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Entity class representing a Ledger
@Entity
@Table (name = "ledgers")
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;   // Primary key of the ledger

    @NotNull(message = "User ID cannot be null")
    private Long userId;   // ID of the user who owns the ledger.

    @NotBlank(message = "Currency is required")
    private String currency;   // Currency type of the ledger

    @NotBlank(message = "Bank is required")
    private String bank;   // Bank name associated with the ledger

    // Getters
    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getCurrency() {
        return currency;
    }

    public String getBank() {
        return bank;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

}
