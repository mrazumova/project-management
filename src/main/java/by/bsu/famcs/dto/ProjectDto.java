package by.bsu.famcs.dto;

import by.bsu.famcs.entity.PricingModel;
import by.bsu.famcs.entity.ProjectType;
import by.bsu.famcs.entity.Status;
import by.bsu.famcs.entity.SupportType;

import java.time.LocalDateTime;

public class ProjectDto {

    private String id;

    private String name;

    private String description;

    private ProjectType type;

    private PricingModel pricingModel;

    private Status status;

    private ManagerDto manager;

    private LocalDateTime started;

    private LocalDateTime finished;

    private SupportType supportType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
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

    public ManagerDto getManager() {
        return manager;
    }

    public void setManager(ManagerDto manager) {
        this.manager = manager;
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

    public SupportType getSupportType() {
        return supportType;
    }

    public void setSupportType(SupportType supportType) {
        this.supportType = supportType;
    }
}
