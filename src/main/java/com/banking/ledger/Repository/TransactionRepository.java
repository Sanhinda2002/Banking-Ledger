package com.banking.ledger.Repository;

import com.banking.ledger.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository <Transaction, Long> {
    List<Transaction> findByLedgerId(Long ledgerId);   // Retrieves all transactions associated with a user
}
