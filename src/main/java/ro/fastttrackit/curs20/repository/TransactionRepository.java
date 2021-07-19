package ro.fastttrackit.curs20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.fastttrackit.curs20.entity.Transaction;
import ro.fastttrackit.curs20.entity.Type;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByType(Type type);

    List<Transaction> findByMinAmount(double minAmount);

    List<Transaction> findByMaxAmount(double maxAmount);

    List<Transaction> findByTypeAndMin(Type type, double minAmount);

    List<Transaction> findByTypeAndMax(Type type, double maxAmount);

    List<Transaction> findByMinAndMax(double minAmount, double maxAmount);

    List<Transaction> findByTypeAndMinAndMax(Type type, double minAmount, double maxAmount);

    @Query(value = "SELECT * from Transaction where product=:prod", nativeQuery = true)
    List<Transaction> getMyTransactions(@Param("desc") String prod);
}
