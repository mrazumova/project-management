package by.bsu.famcs.filter;

import by.bsu.famcs.entity.Project;

import java.time.LocalDateTime;

public class ExpenseHistoryFilter {

    private Long amount;

    private LocalDateTime expenseDate;

    private Project project;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
