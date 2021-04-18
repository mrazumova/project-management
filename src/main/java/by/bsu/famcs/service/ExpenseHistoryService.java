package by.bsu.famcs.service;

import by.bsu.famcs.dto.ExpenseHistoryDto;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpenseHistoryService extends CrudService<ExpenseHistoryDto> {

    Page<ExpenseHistoryDto> findAll(ExpenseHistoryFilter filter, Pageable pageable);
}
