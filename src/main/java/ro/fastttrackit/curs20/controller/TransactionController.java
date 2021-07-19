package ro.fastttrackit.curs20.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fastttrackit.curs20.entity.Transaction;
import ro.fastttrackit.curs20.entity.Type;
import ro.fastttrackit.curs20.service.TransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getById(@PathVariable Integer id) {
        return transactionService.getById(id);
    }

    @PostMapping
    Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }

    @PutMapping("{transactionId}")
    public Optional<Transaction> replaceTransaction(@PathVariable Integer transactionId,
                                                    @RequestBody Transaction newTransaction) {
        return transactionService.replace(transactionId, newTransaction);
    }

    @PatchMapping("{transactionId}")
    public Transaction updateTransaction(@PathVariable Integer transactionId,
                                         @RequestBody Transaction newTransaction) {
        return transactionService.update(transactionId, newTransaction);
    }

    @DeleteMapping("{transactionId}")
    void delete(@PathVariable Integer transactionId) {
        transactionService.delete(transactionId);
    }
}
