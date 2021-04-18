package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.ProjectDto;
import by.bsu.famcs.entity.Project;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.ProjectMapper;
import by.bsu.famcs.repository.ProjectRepository;
import by.bsu.famcs.service.ManagerService;
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
    public AbstractMapper<Project, ProjectDto> projectMapper(ManagerService managerService) {
        return new ProjectMapper(managerService);
    }

    @Bean
    public ProjectService projectService(AbstractMapper<Project, ProjectDto> projectMapper) {
        return new ProjectServiceImpl(projectRepository, projectMapper);
    }
}
