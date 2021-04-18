package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.ProjectAnalyticsDto;
import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.service.ProjectService;

import javax.annotation.PostConstruct;

public class ProjectAnalyticsMapper extends DefaultMapper<ProjectAnalytics, ProjectAnalyticsDto> {

    private final ProjectService projectService;

    public ProjectAnalyticsMapper(ProjectService projectService) {
        super(ProjectAnalytics.class, ProjectAnalyticsDto.class);
        this.projectService = projectService;
    }

    @PostConstruct
    void setupMapper() {
        mapper.createTypeMap(ProjectAnalytics.class, ProjectAnalyticsDto.class)
                .addMappings(m -> m.skip(ProjectAnalyticsDto::setProject)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(ProjectAnalyticsDto.class, ProjectAnalytics.class)
                .addMappings(m -> m.skip(ProjectAnalytics::setProjectId)).setPostConverter(toEntityConverter());
    }

    @Override
    void specificMapToDto(ProjectAnalytics entity, ProjectAnalyticsDto dto) {
        if (entity.getProjectId() != null)
            dto.setProject(projectService.findById(entity.getProjectId()).orElseGet(null));
    }

    @Override
    void specificMapToEntity(ProjectAnalyticsDto dto, ProjectAnalytics entity) {
        if (dto.getProject() != null)
            entity.setProjectId(dto.getProject().getId());
    }

}
