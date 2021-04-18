package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.ProjectDto;
import by.bsu.famcs.entity.Project;
import by.bsu.famcs.service.ManagerService;

import javax.annotation.PostConstruct;

public class ProjectMapper extends DefaultMapper<Project, ProjectDto> {

    private final ManagerService managerService;

    public ProjectMapper(ManagerService managerService) {
        super(Project.class, ProjectDto.class);
        this.managerService = managerService;
    }

    @PostConstruct
    void setupMapper() {
        mapper.createTypeMap(Project.class, ProjectDto.class)
                .addMappings(m -> m.skip(ProjectDto::setManager)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(ProjectDto.class, Project.class)
                .addMappings(m -> m.skip(Project::setManagerId)).setPostConverter(toEntityConverter());
    }

    @Override
    void specificMapToDto(Project entity, ProjectDto dto) {
        if (entity.getManagerId() != null)
            dto.setManager(managerService.findById(entity.getManagerId()).orElseGet(null));
    }

    @Override
    void specificMapToEntity(ProjectDto dto, Project entity) {
        if (dto.getManager() != null)
            entity.setManagerId(dto.getManager().getId());
    }
}
