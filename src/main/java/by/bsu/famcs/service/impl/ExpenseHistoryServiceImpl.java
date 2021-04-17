package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import by.bsu.famcs.repository.ExpenseHistoryRepository;
import by.bsu.famcs.service.ExpenseHistoryService;
import by.bsu.famcs.specification.ExpenseHistorySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ExpenseHistoryServiceImpl extends DefaultCrudService<ExpenseHistory> implements ExpenseHistoryService {

    private final ExpenseHistoryRepository expenseHistoryRepository;

    public ExpenseHistoryServiceImpl(ExpenseHistoryRepository expenseHistoryRepository) {
        this.expenseHistoryRepository = expenseHistoryRepository;
    }

    @Override
    public Page<ExpenseHistory> findAll(ExpenseHistoryFilter filter, Pageable pageable) {
        return expenseHistoryRepository.findAll(new ExpenseHistorySpecification(filter), pageable);
    }

    @Override
    public ExpenseHistory update(ExpenseHistory entity, String entityId) {
        ExpenseHistory expenseHistory = getEntity(entityId);
        update(entity, expenseHistory);
        return expenseHistoryRepository.save(expenseHistory);
    }

    private static void update(ExpenseHistory entity, ExpenseHistory toUpdate) {
        toUpdate.setProject(entity.getProject());
        toUpdate.setAmount(entity.getAmount());
        toUpdate.setExpenseDate(entity.getExpenseDate());
    }

    @Override
    protected CrudRepository<ExpenseHistory, String> getRepository() {
        return expenseHistoryRepository;
    }
}
