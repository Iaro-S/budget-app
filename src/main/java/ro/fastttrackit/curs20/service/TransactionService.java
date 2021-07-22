package ro.fastttrackit.curs20.service;

import org.springframework.stereotype.Service;
import ro.fastttrackit.curs20.entity.Transaction;
import ro.fastttrackit.curs20.repository.TransactionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getById(Integer id) {
        return transactionRepository.findById(id);
    }

    public Transaction create(Transaction transaction) {
        transaction.setId(null);
        return transactionRepository.save(transaction);
    }

    public void delete(Integer transactionId) {
        boolean exist = transactionRepository.existsById(transactionId);
        if (!exist) {
            throw new IllegalStateException("Transaction with id: " + transactionId + " does not exist");
        }
        transactionRepository.deleteById(transactionId);
    }

    public Optional<Transaction> replace(Integer transactionId, Transaction newTransaction) {
        Optional<Transaction> replacedTransaction = transactionRepository.findById(transactionId);
        if (replacedTransaction.isPresent()) {
            transactionRepository.deleteById(transactionId);
            newTransaction.setId(transactionId);
            transactionRepository.save(newTransaction);
        }
        return replacedTransaction;
    }

    public Transaction update(Integer transactionId, Transaction newTransaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(transactionId);

        if (!existingTransaction.isPresent()) {
            throw new IllegalStateException("Transaction not found");
        }

        Transaction result = existingTransaction.get();
        result.setId(result.getId());
        result.setProduct(newTransaction.getProduct() != null ? newTransaction.getProduct() : result.getProduct());
        result.setType(result.getType());
        result.setAmount(newTransaction.getAmount() != 0 ? newTransaction.getAmount() : result.getAmount());

        return transactionRepository.save(result);

    }
}
