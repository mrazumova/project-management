package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.UnitDto;
import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.service.DepartmentService;

import javax.annotation.PostConstruct;

public class UnitMapper extends DefaultMapper<Unit, UnitDto> {

    private final DepartmentService departmentService;

    public UnitMapper(DepartmentService departmentService) {
        super(Unit.class, UnitDto.class);
        this.departmentService = departmentService;
    }

    @PostConstruct
    void setupMapper() {
        mapper.createTypeMap(Unit.class, UnitDto.class)
                .addMappings(m -> m.skip(UnitDto::setDepartment)).setPostConverter(toDtoConverter());

        mapper.createTypeMap(UnitDto.class, Unit.class)
                .addMappings(m -> m.skip(Unit::setDepartmentId)).setPostConverter(toEntityConverter());
    }

    @Override
    void specificMapToDto(Unit entity, UnitDto dto) {
        if (entity.getDepartmentId() != null)
            dto.setDepartment(departmentService.findById(entity.getDepartmentId()).orElseGet(null));
    }

    @Override
    void specificMapToEntity(UnitDto dto, Unit entity) {
        if (dto.getDepartment() != null)
            entity.setDepartmentId(dto.getDepartment().getId());
    }
}
