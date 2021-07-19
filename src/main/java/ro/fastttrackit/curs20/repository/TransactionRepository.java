package ro.fastttrackit.curs20.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fastttrackit.curs20.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
