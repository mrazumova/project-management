package by.bsu.famcs.dto;

import java.time.LocalDateTime;

public class ExpenseHistoryDto {

    private String id;

    private long amount;

    private LocalDateTime expenseDate;

    private ProjectDto project;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
