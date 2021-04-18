package by.bsu.famcs.dto;

public class ProjectAnalyticsDto {

    private String id;

    private ProjectDto project;

    private long forecastedCost;

    private long alreadySpent;

    private long alreadyReceived;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
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
