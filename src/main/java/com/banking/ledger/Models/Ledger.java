package com.banking.ledger.Models;

import jakarta.persistence.*;

@Entity
@Table (name = "ledgers")
public class Ledger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private long userId;
    private String currency;
    private String bank;

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
