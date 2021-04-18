package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.PaymentHistoryDto;
import by.bsu.famcs.entity.PaymentHistory;
import by.bsu.famcs.service.ProjectService;

import javax.annotation.PostConstruct;

public class PaymentHistoryMapper extends DefaultMapper<PaymentHistory, PaymentHistoryDto> {

    private final ProjectService projectService;

    public PaymentHistoryMapper(ProjectService projectService) {
        super(PaymentHistory.class, PaymentHistoryDto.class);
        this.projectService = projectService;
    }

    @PostConstruct
    void setupMapper() {
        mapper.createTypeMap(PaymentHistory.class, PaymentHistoryDto.class)
                .addMappings(m -> m.skip(PaymentHistoryDto::setProject)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(PaymentHistoryDto.class, PaymentHistory.class)
                .addMappings(m -> m.skip(PaymentHistory::setProjectId)).setPostConverter(toEntityConverter());
    }

    @Override
    void specificMapToDto(PaymentHistory entity, PaymentHistoryDto dto) {
        if (entity.getProjectId() != null)
            dto.setProject(projectService.findById(entity.getProjectId()).orElseGet(null));
    }

    @Override
    void specificMapToEntity(PaymentHistoryDto dto, PaymentHistory entity) {
        if (dto.getProject() != null)
            entity.setProjectId(dto.getProject().getId());
    }
}
