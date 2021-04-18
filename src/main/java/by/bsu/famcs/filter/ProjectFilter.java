package by.bsu.famcs.filter;

import by.bsu.famcs.entity.PricingModel;
import by.bsu.famcs.entity.Status;
import by.bsu.famcs.entity.SupportType;

import java.time.LocalDateTime;

public class ProjectFilter {

    private String name;

    private String type;

    private PricingModel pricingModel;

    private Status status;

    private String managerId;

    private SupportType supportType;

    private LocalDateTime started;

    private LocalDateTime finished;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PricingModel getPricingModel() {
        return pricingModel;
    }

    public void setPricingModel(PricingModel pricingModel) {
        this.pricingModel = pricingModel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public SupportType getSupportType() {
        return supportType;
    }

    public void setSupportType(SupportType supportType) {
        this.supportType = supportType;
    }

    public LocalDateTime getStarted() {
        return started;
    }

    public void setStarted(LocalDateTime started) {
        this.started = started;
    }

    public LocalDateTime getFinished() {
        return finished;
    }

    public void setFinished(LocalDateTime finished) {
        this.finished = finished;
    }
}
