package by.bsu.famcs.filter;

public class ProjectAnalyticsFilter {

    private String forecastedCost;

    private Long alreadySpent;

    private Long alreadyReceived;

    private String projectId;

    public String getForecastedCost() {
        return forecastedCost;
    }

    public void setForecastedCost(String forecastedCost) {
        this.forecastedCost = forecastedCost;
    }

    public Long getAlreadySpent() {
        return alreadySpent;
    }

    public void setAlreadySpent(Long alreadySpent) {
        this.alreadySpent = alreadySpent;
    }

    public Long getAlreadyReceived() {
        return alreadyReceived;
    }

    public void setAlreadyReceived(Long alreadyReceived) {
        this.alreadyReceived = alreadyReceived;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
