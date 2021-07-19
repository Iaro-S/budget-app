package ro.fastttrackit.curs20;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fastttrackit.curs20.entity.Transaction;
import ro.fastttrackit.curs20.repository.TransactionRepository;
import ro.fastttrackit.curs20.entity.Type;

import java.util.List;

@SpringBootApplication
public class BudgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudgetApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository repository) {
        return args -> repository.saveAll((List.of(
                new Transaction("Dodge", Type.BUY, 80207.11),
                new Transaction("Hyundai", Type.SELL, 24819.88),
                new Transaction("Subaru", Type.BUY, 95729.69),
                new Transaction("Subaru", Type.SELL, 37185.47),
                new Transaction("Saturn", Type.BUY, 7925.82),
                new Transaction("Volvo", Type.BUY, 44544),
                new Transaction("Ford", Type.SELL, 22187.63),
                new Transaction("GMC", Type.SELL, 112935.52),
                new Transaction("Dodge", Type.BUY, 11609.72),
                new Transaction("Dodge", Type.BUY, 17711.73)
        )));
    }
}
