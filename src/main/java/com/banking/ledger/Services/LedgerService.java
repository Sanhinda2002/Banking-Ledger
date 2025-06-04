package com.banking.ledger.Services;

import com.banking.ledger.Models.Ledger;
import com.banking.ledger.Models.Transaction;
import com.banking.ledger.Repository.LedgerRepository;
import com.banking.ledger.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LedgerService {
    private final LedgerRepository ledgerRepository;
    private final TransactionRepository transactionRepository;

    public LedgerService (LedgerRepository ledgerRepository, TransactionRepository transactionRepository){
        this.ledgerRepository = ledgerRepository;
        this.transactionRepository = transactionRepository;
    }

    public LedgerRepository getLedgerRepository() {
        return ledgerRepository;
    }

    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    // Creating a new ledger
    public Ledger createLedger (Ledger ledger){
        return ledgerRepository.save(ledger);
    }

    // Get all ledgers for a user
    public List<Ledger> getLedgersByUser (Long userId){
        return ledgerRepository.findByUserId(userId);
    }

    // Get a single ledger by id
    public Ledger getLedger (Long ledgerId){
        return ledgerRepository.findById(ledgerId)
                .orElseThrow(()->new RuntimeException("Ledger was not found"));
    }

    // Add a transaction to the ledger
    public Transaction addTransaction (Long ledgerId, Transaction transaction){
        Ledger ledger= getLedger(ledgerId);
        transaction.setLedger(ledger);
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

}
