package com.banking.ledger.Repository;

import com.banking.ledger.Models.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LedgerRepository extends JpaRepository <Ledger,long> {
    List<Ledger> findByUserId (Long userId);
}
