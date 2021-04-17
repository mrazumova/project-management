package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.ProjectRepository;
import by.bsu.famcs.service.ProjectService;
import by.bsu.famcs.service.impl.ProjectServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    private final ProjectRepository projectRepository;

    public ProjectConfiguration(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Bean
    public ProjectService projectService() {
        return new ProjectServiceImpl(projectRepository);
    }
}
