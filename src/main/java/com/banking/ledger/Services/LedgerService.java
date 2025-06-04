package com.banking.ledger.Services;

import com.banking.ledger.Repository.LedgerRepository;
import com.banking.ledger.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

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

    
}
