package by.bsu.famcs.controller;

import by.bsu.famcs.dto.ExpenseHistoryDto;
import by.bsu.famcs.filter.ExpenseHistoryFilter;
import by.bsu.famcs.service.ExpenseHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static by.bsu.famcs.security.SecurityPermission.EDIT_PAYMENTS;
import static by.bsu.famcs.security.SecurityPermission.READ_PAYMENTS;

@RestController
@RequestMapping("/expense-history")
public class ExpenseHistoryController {

    private static final String EXPENSE_HISTORY_ID_PARAM = "{expenseHistoryId}";

    private final ExpenseHistoryService expenseHistoryService;

    public ExpenseHistoryController(ExpenseHistoryService expenseHistoryService) {
        this.expenseHistoryService = expenseHistoryService;
    }

    @Secured(READ_PAYMENTS)
    @GetMapping
    public Page<ExpenseHistoryDto> getAllExpenseHistories(ExpenseHistoryFilter filter, Pageable pageable) {
        return expenseHistoryService.findAll(filter, pageable);
    }

    @Secured(READ_PAYMENTS)
    @GetMapping(EXPENSE_HISTORY_ID_PARAM)
    public ResponseEntity<ExpenseHistoryDto> getExpenseHistoryById(@PathVariable String expenseHistoryId) {
        return ResponseEntity.of(expenseHistoryService.findById(expenseHistoryId));
    }

    @Secured(EDIT_PAYMENTS)
    @PostMapping
    public ExpenseHistoryDto createExpenseHistory(@RequestBody ExpenseHistoryDto expenseHistory) {
        return expenseHistoryService.create(expenseHistory);
    }

    @Secured(EDIT_PAYMENTS)
    @PutMapping(EXPENSE_HISTORY_ID_PARAM)
    public ExpenseHistoryDto updateExpenseHistory(@RequestBody ExpenseHistoryDto expenseHistory, @PathVariable String expenseHistoryId) {
        return expenseHistoryService.update(expenseHistory, expenseHistoryId);
    }

    @Secured(EDIT_PAYMENTS)
    @DeleteMapping(EXPENSE_HISTORY_ID_PARAM)
    public void removeExpenseHistory(@PathVariable String expenseHistoryId) {
        expenseHistoryService.deleteById(expenseHistoryId);
    }

}
