package com.banking.ledger.Controllers;

import com.banking.ledger.Models.Ledger;
import com.banking.ledger.Models.Transaction;
import com.banking.ledger.Services.LedgerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller for managing ledger endpoints
@RestController
@RequestMapping("api")
public class LedgerController {
    private final LedgerService ledgerService;

    public LedgerController (LedgerService ledgerService){
        this.ledgerService = ledgerService;
    }

    // Creates a new ledger
    @PostMapping("/ledgers")
    public Ledger createLedger (@Valid @RequestBody Ledger ledger){
        return ledgerService.createLedger(ledger);
    }

    // Retrieves a specific ledger by its ID
    @GetMapping("/ledgers/{ledgerId}")
    public Ledger getLedger (@PathVariable Long ledgerId){
        return ledgerService.getLedger(ledgerId);
    }

    // Retrieves all ledgers associated with a specific user
    @GetMapping("/users/{userId}/ledgers")
    public List<Ledger> getUserLedgers (@PathVariable Long userId){
        return ledgerService.getLedgersByUser(userId);
    }

    // Adds a transaction to a specific ledger
    @PostMapping("/ledgers/{ledgerId}/transactions")
    public Transaction addTransactions(@PathVariable Long ledgerId, @Valid @RequestBody Transaction transaction){
        return ledgerService.addTransaction(ledgerId, transaction);
    }

    // Retrieves all transactions associated with a specific ledger
    @GetMapping("/ledgers/{ledgerId}/transactions")
    public List<Transaction> getTransaction(@PathVariable Long ledgerId){
        return ledgerService.getTransactions(ledgerId);
    }



}
