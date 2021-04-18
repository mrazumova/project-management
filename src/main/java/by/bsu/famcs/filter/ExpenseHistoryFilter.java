package by.bsu.famcs.filter;

import java.time.LocalDateTime;

public class ExpenseHistoryFilter {

    private Long amount;

    private LocalDateTime expenseDate;

    private String projectId;

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

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
