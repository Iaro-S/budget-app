package ro.fastttrackit.curs20;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fastttrackit.curs20.entity.Transaction;
import ro.fastttrackit.curs20.repository.TransactionRepository;

import java.util.List;

import static org.springframework.boot.SpringApplication.run;
import static ro.fastttrackit.curs20.entity.Type.*;

@SpringBootApplication
public class BudgetApplication {

    public static void main(String[] args) {
        run(BudgetApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository repository) {
        return args -> repository.saveAll((List.of(
                new Transaction("Dodge", BUY, 80207.11),
                new Transaction("Hyundai", SELL, 24819.88),
                new Transaction("Subaru", BUY, 95729.69),
                new Transaction("Subaru", SELL, 37185.47),
                new Transaction("Saturn", BUY, 7925.82),
                new Transaction("Volvo", BUY, 44544.00),
                new Transaction("Ford", SELL, 22187.63),
                new Transaction("GMC", SELL, 112935.52),
                new Transaction("Dodge", BUY, 11609.72),
                new Transaction("Dodge", BUY, 17711.73)
        )));
    }
}
