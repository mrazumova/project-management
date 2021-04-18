package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.ManagerDto;
import by.bsu.famcs.entity.Manager;
import by.bsu.famcs.service.UnitService;

import javax.annotation.PostConstruct;

public class ManagerMapper extends DefaultMapper<Manager, ManagerDto> {

    private final UnitService unitService;

    public ManagerMapper(UnitService unitService) {
        super(Manager.class, ManagerDto.class);
        this.unitService = unitService;
    }

    @PostConstruct
    void setupMapper() {
        mapper.createTypeMap(Manager.class, ManagerDto.class)
                .addMappings(m -> m.skip(ManagerDto::setUnit)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(ManagerDto.class, Manager.class)
                .addMappings(m -> m.skip(Manager::setUnitId)).setPostConverter(toEntityConverter());
    }

    @Override
    void specificMapToDto(Manager entity, ManagerDto dto) {
        if (entity.getUnitId() != null)
            dto.setUnit(unitService.findById(entity.getUnitId()).orElseGet(null));

    }

    @Override
    void specificMapToEntity(ManagerDto dto, Manager entity) {
        if (dto.getUnit() != null)
            entity.setUnitId(dto.getUnit().getId());
    }
}
