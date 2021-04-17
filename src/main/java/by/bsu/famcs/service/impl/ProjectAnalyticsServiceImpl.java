package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.filter.ProjectAnalyticsFilter;
import by.bsu.famcs.repository.ProjectAnalyticsRepository;
import by.bsu.famcs.service.ProjectAnalyticsService;
import by.bsu.famcs.specification.ProjectAnalyticsSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ProjectAnalyticsServiceImpl extends DefaultCrudService<ProjectAnalytics> implements ProjectAnalyticsService {

    private final ProjectAnalyticsRepository projectAnalyticsRepository;

    public ProjectAnalyticsServiceImpl(ProjectAnalyticsRepository projectAnalyticsRepository) {
        this.projectAnalyticsRepository = projectAnalyticsRepository;
    }

    @Override
    public Page<ProjectAnalytics> findAll(ProjectAnalyticsFilter filter, Pageable pageable) {
        return projectAnalyticsRepository.findAll(new ProjectAnalyticsSpecification(filter), pageable);
    }

    @Override
    public ProjectAnalytics update(ProjectAnalytics entity, String entityId) {
        ProjectAnalytics projectAnalytics = new ProjectAnalytics();
        update(entity, projectAnalytics);
        return projectAnalyticsRepository.save(projectAnalytics);
    }

    private static void update(ProjectAnalytics entity, ProjectAnalytics toUpdate) {
        toUpdate.setForecastedCost(entity.getForecastedCost());
        toUpdate.setAlreadyReceived(entity.getAlreadyReceived());
        toUpdate.setAlreadySpent(entity.getAlreadySpent());
    }

    @Override
    protected CrudRepository<ProjectAnalytics, String> getRepository() {
        return projectAnalyticsRepository;
    }
}
