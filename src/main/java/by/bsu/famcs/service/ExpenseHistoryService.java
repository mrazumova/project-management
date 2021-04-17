package by.bsu.famcs.service;

import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpenseHistoryService extends CrudService<ExpenseHistory> {

    Page<ExpenseHistory> findAll(ExpenseHistoryFilter filter, Pageable pageable);
}
