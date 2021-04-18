package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.ExpenseHistoryDto;
import by.bsu.famcs.entity.ExpenseHistory;
import by.bsu.famcs.service.ProjectService;

import javax.annotation.PostConstruct;

public class ExpenseHistoryMapper extends DefaultMapper<ExpenseHistory, ExpenseHistoryDto> {

    private final ProjectService projectService;

    public ExpenseHistoryMapper(ProjectService projectService) {
        super(ExpenseHistory.class, ExpenseHistoryDto.class);
        this.projectService = projectService;
    }

    @PostConstruct
    void setupMapper() {
        mapper.createTypeMap(ExpenseHistory.class, ExpenseHistoryDto.class)
                .addMappings(m -> m.skip(ExpenseHistoryDto::setProject)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(ExpenseHistoryDto.class, ExpenseHistory.class)
                .addMappings(m -> m.skip(ExpenseHistory::setProjectId)).setPostConverter(toEntityConverter());
    }

    @Override
    void specificMapToDto(ExpenseHistory entity, ExpenseHistoryDto dto) {
        if (entity.getProjectId() != null)
            dto.setProject(projectService.findById(entity.getProjectId()).orElseGet(null));
    }

    @Override
    void specificMapToEntity(ExpenseHistoryDto dto, ExpenseHistory entity) {
        if (dto.getProject() != null)
            entity.setProjectId(dto.getProject().getId());
    }
}
