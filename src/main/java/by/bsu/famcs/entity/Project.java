package by.bsu.famcs.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ProjectType type;

    @Column(name = "pricing_model")
    @Enumerated(EnumType.STRING)
    private PricingModel pricingModel;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "manager_id")
    private String managerId;

    @Column(name = "started")
    private LocalDateTime started;

    @Column(name = "finished")
    private LocalDateTime finished;

    @Column(name = "support_type")
    @Enumerated(EnumType.STRING)
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

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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
