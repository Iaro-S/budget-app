package ro.fastttrackit.curs20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fastttrackit.curs20.entity.Transaction;
import ro.fastttrackit.curs20.entity.Type;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByType(Type type);
    List<Transaction> findByAmountGreaterThan(Double minAmount);
    List<Transaction> findByTypeAndAmountGreaterThan(Type type, double minAmount);
    List<Transaction> findByTypeAndAmountGreaterThanAndAmountLessThan(Type type, Double minAmount, Double maxAmount);
    List<Transaction> findByAmountLessThan(double minAmount);
    List<Transaction> findByTypeAndAmountLessThan(Type type, Double minAmount);
    List<Transaction> AmountGreaterThanAndAmountLessThan(Double minAmount, Double maxAmount);
}