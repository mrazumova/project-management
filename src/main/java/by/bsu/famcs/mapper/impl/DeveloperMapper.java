package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.DeveloperDto;
import by.bsu.famcs.entity.Developer;
import by.bsu.famcs.service.ProjectService;
import by.bsu.famcs.service.UnitService;

import javax.annotation.PostConstruct;

public class DeveloperMapper extends DefaultMapper<Developer, DeveloperDto> {

    private final UnitService unitService;

    private final ProjectService projectService;

    public DeveloperMapper(UnitService unitService, ProjectService projectService) {
        super(Developer.class, DeveloperDto.class);
        this.unitService = unitService;
        this.projectService = projectService;
    }

    @PostConstruct
    void setupMapper() {
        mapper.createTypeMap(Developer.class, DeveloperDto.class)
                .addMappings(m -> m.skip(DeveloperDto::setUnit)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(DeveloperDto::setProject)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(DeveloperDto.class, Developer.class)
                .addMappings(m -> m.skip(Developer::setUnitId)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Developer::setProjectId)).setPostConverter(toEntityConverter());
    }

    @Override
    void specificMapToDto(Developer entity, DeveloperDto dto) {
        if (entity.getUnitId() != null)
            dto.setUnit(unitService.findById(entity.getUnitId()).orElseGet(null));

        if (entity.getProjectId() != null)
            dto.setProject(projectService.findById(entity.getProjectId()).orElseGet(null));
    }

    @Override
    void specificMapToEntity(DeveloperDto dto, Developer entity) {
        if (dto.getUnit() != null)
            entity.setUnitId(dto.getUnit().getId());

        if (dto.getProject() != null)
            entity.setProjectId(dto.getProject().getId());
    }
}
