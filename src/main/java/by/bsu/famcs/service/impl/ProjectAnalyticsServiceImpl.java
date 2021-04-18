package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.ProjectAnalyticsDto;
import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.filter.ProjectAnalyticsFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.ProjectAnalyticsRepository;
import by.bsu.famcs.service.ProjectAnalyticsService;
import by.bsu.famcs.specification.ProjectAnalyticsSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ProjectAnalyticsServiceImpl extends DefaultCrudService<ProjectAnalytics, ProjectAnalyticsDto> implements ProjectAnalyticsService {

    private final ProjectAnalyticsRepository projectAnalyticsRepository;

    public ProjectAnalyticsServiceImpl(ProjectAnalyticsRepository projectAnalyticsRepository, AbstractMapper<ProjectAnalytics, ProjectAnalyticsDto> mapper) {
        super(mapper);
        this.projectAnalyticsRepository = projectAnalyticsRepository;
    }

    @Override
    public Page<ProjectAnalyticsDto> findAll(ProjectAnalyticsFilter filter, Pageable pageable) {
        return projectAnalyticsRepository.findAll(new ProjectAnalyticsSpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public ProjectAnalyticsDto update(ProjectAnalyticsDto dto, String entityId) {
        ProjectAnalytics projectAnalytics = new ProjectAnalytics();
        update(dto, projectAnalytics);
        return mapper.toDto(projectAnalyticsRepository.save(projectAnalytics));
    }

    private static void update(ProjectAnalyticsDto dto, ProjectAnalytics entity) {
        entity.setForecastedCost(dto.getForecastedCost());
        entity.setAlreadyReceived(dto.getAlreadyReceived());
        entity.setAlreadySpent(dto.getAlreadySpent());
        entity.setProjectId(dto.getProject().getId());
    }

    @Override
    protected CrudRepository<ProjectAnalytics, String> getRepository() {
        return projectAnalyticsRepository;
    }
}
