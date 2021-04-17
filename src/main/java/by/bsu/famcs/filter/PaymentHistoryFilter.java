package by.bsu.famcs.filter;

import by.bsu.famcs.entity.Project;

import java.time.LocalDateTime;

public class PaymentHistoryFilter {

    private Long amount;

    private LocalDateTime paymentDate;

    private Project project;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
