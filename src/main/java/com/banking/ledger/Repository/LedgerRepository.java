package com.banking.ledger.Repository;

import com.banking.ledger.Models.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LedgerRepository extends JpaRepository <Ledger,Long> {
    List<Ledger> findByUserId (Long userId);   // Retrieves all ledgers associated with a user
}
