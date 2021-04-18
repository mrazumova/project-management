package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.ExpenseHistoryDto;
import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.ExpenseHistoryMapper;
import by.bsu.famcs.repository.ExpenseHistoryRepository;
import by.bsu.famcs.service.ExpenseHistoryService;
import by.bsu.famcs.service.ProjectService;
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
    public AbstractMapper<ExpenseHistory, ExpenseHistoryDto> expenseHistoryMapper(ProjectService projectService) {
        return new ExpenseHistoryMapper(projectService);
    }

    @Bean
    public ExpenseHistoryService expenseHistoryService(AbstractMapper<ExpenseHistory, ExpenseHistoryDto> expenseHistoryMapper) {
        return new ExpenseHistoryServiceImpl(expenseHistoryRepository, expenseHistoryMapper);
    }
}
