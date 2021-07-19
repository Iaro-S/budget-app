package ro.fastttrackit.curs20.service;

import org.springframework.stereotype.Service;
import ro.fastttrackit.curs20.entity.Transaction;
import ro.fastttrackit.curs20.entity.Type;
import ro.fastttrackit.curs20.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll(String product, Type type, Double minAmount, Double maxAmount) {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getById(Integer id) {
        return transactionRepository.findById(id);
    }

    public Transaction create(Transaction transaction) {
        transaction.setId(null);
        return transactionRepository.save(transaction);
    }

    public Optional<Transaction> delete(Integer transactionId) {
        Optional<Transaction> optionalTransaction = getById(transactionId);
        if (optionalTransaction.isPresent()) {
            transactionRepository.deleteById(transactionId);
        }
        return optionalTransaction;
    }

    public Optional<Transaction> update(Integer transactionId, Transaction newTransaction) {
        Optional<Transaction> replacedTransaction = delete(transactionId);
        if (replacedTransaction.isPresent()) {
            newTransaction.setId(transactionId);
            transactionRepository.save(newTransaction);
        }
        return replacedTransaction;
    }
}
