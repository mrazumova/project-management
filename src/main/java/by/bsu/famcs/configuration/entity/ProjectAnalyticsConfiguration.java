package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.ProjectAnalyticsDto;
import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.ProjectAnalyticsMapper;
import by.bsu.famcs.repository.ProjectAnalyticsRepository;
import by.bsu.famcs.service.ProjectAnalyticsService;
import by.bsu.famcs.service.ProjectService;
import by.bsu.famcs.service.impl.ProjectAnalyticsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectAnalyticsConfiguration {

    private final ProjectAnalyticsRepository projectAnalyticsRepository;

    public ProjectAnalyticsConfiguration(ProjectAnalyticsRepository projectAnalyticsRepository) {
        this.projectAnalyticsRepository = projectAnalyticsRepository;
    }

    @Bean
    public AbstractMapper<ProjectAnalytics, ProjectAnalyticsDto> projectAnalyticsMapper(ProjectService projectService) {
        return new ProjectAnalyticsMapper(projectService);
    }

    @Bean
    public ProjectAnalyticsService projectAnalyticsService(AbstractMapper<ProjectAnalytics, ProjectAnalyticsDto> projectAnalyticsMapper) {
        return new ProjectAnalyticsServiceImpl(projectAnalyticsRepository, projectAnalyticsMapper);
    }
}
