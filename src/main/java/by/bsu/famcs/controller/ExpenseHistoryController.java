package by.bsu.famcs.controller;

import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import by.bsu.famcs.service.ExpenseHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expense-history")
public class ExpenseHistoryController {

    private static final String EXPENSE_HISTORY_ID_PARAM = "{expenseHistoryId}";

    private final ExpenseHistoryService expenseHistoryService;

    public ExpenseHistoryController(ExpenseHistoryService expenseHistoryService) {
        this.expenseHistoryService = expenseHistoryService;
    }

    @GetMapping
    public Page<ExpenseHistory> getAllExpenseHistories(ExpenseHistoryFilter filter, Pageable pageable) {
        return expenseHistoryService.findAll(filter, pageable);
    }

    @GetMapping(EXPENSE_HISTORY_ID_PARAM)
    public ResponseEntity<ExpenseHistory> getExpenseHistoryById(@PathVariable String expenseHistoryId) {
        return ResponseEntity.of(expenseHistoryService.findById(expenseHistoryId));
    }

    @PostMapping
    public ExpenseHistory createExpenseHistory(@RequestBody ExpenseHistory expenseHistory) {
        return expenseHistoryService.create(expenseHistory);
    }

    @PutMapping(EXPENSE_HISTORY_ID_PARAM)
    public ExpenseHistory updateExpenseHistory(@RequestBody ExpenseHistory expenseHistory, @PathVariable String expenseHistoryId) {
        return expenseHistoryService.update(expenseHistory, expenseHistoryId);
    }

    @DeleteMapping(EXPENSE_HISTORY_ID_PARAM)
    public void removeExpenseHistory(@PathVariable String expenseHistoryId) {
        expenseHistoryService.deleteById(expenseHistoryId);
    }

}
