package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.ProjectAnalyticsRepository;
import by.bsu.famcs.service.ProjectAnalyticsService;
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
    public ProjectAnalyticsService projectAnalyticsService() {
        return new ProjectAnalyticsServiceImpl(projectAnalyticsRepository);
    }
}
