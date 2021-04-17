package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.ExpenseHistoryRepository;
import by.bsu.famcs.service.ExpenseHistoryService;
import by.bsu.famcs.service.impl.ExpenseHistoryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpenseHistoryConfiguration {

    private final ExpenseHistoryRepository expenseHistoryRepository;

    public ExpenseHistoryConfiguration(ExpenseHistoryRepository expenseHistoryRepository) {
        this.expenseHistoryRepository = expenseHistoryRepository;
    }

    @Bean
    public ExpenseHistoryService expenseHistoryService() {
        return new ExpenseHistoryServiceImpl(expenseHistoryRepository);
    }
}
