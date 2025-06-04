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
}
