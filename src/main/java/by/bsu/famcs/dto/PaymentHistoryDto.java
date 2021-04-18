package by.bsu.famcs.dto;

import java.time.LocalDateTime;

public class PaymentHistoryDto {

    private String id;

    private long amount;

    private LocalDateTime paymentDate;

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

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }
}
