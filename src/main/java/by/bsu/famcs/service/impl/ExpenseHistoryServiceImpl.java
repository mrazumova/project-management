package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.ExpenseHistoryDto;
import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.ExpenseHistoryRepository;
import by.bsu.famcs.service.ExpenseHistoryService;
import by.bsu.famcs.specification.ExpenseHistorySpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ExpenseHistoryServiceImpl extends DefaultCrudService<ExpenseHistory, ExpenseHistoryDto> implements ExpenseHistoryService {

    private final ExpenseHistoryRepository expenseHistoryRepository;

    public ExpenseHistoryServiceImpl(ExpenseHistoryRepository expenseHistoryRepository, AbstractMapper<ExpenseHistory, ExpenseHistoryDto> mapper) {
        super(mapper);
        this.expenseHistoryRepository = expenseHistoryRepository;
    }

    @Override
    public Page<ExpenseHistoryDto> findAll(ExpenseHistoryFilter filter, Pageable pageable) {
        return expenseHistoryRepository.findAll(new ExpenseHistorySpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public ExpenseHistoryDto update(ExpenseHistoryDto dto, String entityId) {
        ExpenseHistory expenseHistory = getEntity(entityId);
        update(dto, expenseHistory);
        return mapper.toDto(expenseHistoryRepository.save(expenseHistory));
    }

    private static void update(ExpenseHistoryDto dto, ExpenseHistory entity) {
        entity.setProjectId(dto.getProject().getId());
        entity.setAmount(dto.getAmount());
        entity.setExpenseDate(dto.getExpenseDate());
    }

    @Override
    protected CrudRepository<ExpenseHistory, String> getRepository() {
        return expenseHistoryRepository;
    }
}
