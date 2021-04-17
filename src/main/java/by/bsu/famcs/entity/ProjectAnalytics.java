package by.bsu.famcs.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "project_analytics")
public class ProjectAnalytics {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "forecasted_cost")
    private long forecastedCost;

    @Column(name = "already_spent")
    private long alreadySpent;

    @Column(name = "already_received")
    private long alreadyReceived;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getForecastedCost() {
        return forecastedCost;
    }

    public void setForecastedCost(long forecastedCost) {
        this.forecastedCost = forecastedCost;
    }

    public long getAlreadySpent() {
        return alreadySpent;
    }

    public void setAlreadySpent(long alreadySpent) {
        this.alreadySpent = alreadySpent;
    }

    public long getAlreadyReceived() {
        return alreadyReceived;
    }

    public void setAlreadyReceived(long alreadyReceived) {
        this.alreadyReceived = alreadyReceived;
    }
}
