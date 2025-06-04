package com.banking.ledger.Controllers;

import com.banking.ledger.Models.Ledger;
import com.banking.ledger.Models.Transaction;
import com.banking.ledger.Services.LedgerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class LedgerController {
    private final LedgerService ledgerService;

    public LedgerController (LedgerService ledgerService){
        this.ledgerService = ledgerService;
    }

    @PostMapping("/ledgers")
    public Ledger createLedger (@RequestBody Ledger ledger){
        return ledgerService.createLedger(ledger);
    }

    @GetMapping("/ledgers/{ledgerId}")
    public Ledger getLedger (@PathVariable Long ledgerId){
        return ledgerService.getLedger(ledgerId);
    }

    @GetMapping("/users/{userId}/ledgers")
    public List<Ledger> getUserLedgers (@PathVariable Long userId){
        return ledgerService.getLedgersByUser(userId);
    }

    @PostMapping("/ledgers/{ledgerId}/transactions")
    public Transaction addTransactions(@PathVariable Long ledgerId, @RequestBody Transaction transaction){
        return ledgerService.addTransaction(ledgerId, transaction);
    }

    @GetMapping("/ledgers/{ledgerId}/transactions")
    public List<Transaction> getTransaction(@PathVariable Long ledgerId){
        return ledgerService.getTransactions(ledgerId);
    }



}
