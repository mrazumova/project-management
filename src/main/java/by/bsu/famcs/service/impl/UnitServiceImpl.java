package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.UnitDto;
import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.filter.UnitFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.UnitRepository;
import by.bsu.famcs.service.UnitService;
import by.bsu.famcs.specification.UnitSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class UnitServiceImpl extends DefaultCrudService<Unit, UnitDto> implements UnitService {

    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository, AbstractMapper<Unit, UnitDto> mapper) {
        super(mapper);
        this.unitRepository = unitRepository;
    }

    @Override
    public Page<UnitDto> findAll(UnitFilter filter, Pageable pageable) {
        return unitRepository.findAll(new UnitSpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public UnitDto update(UnitDto dto, String entityId) {
        Unit unit = getEntity(entityId);
        update(dto, unit);
        return mapper.toDto(unitRepository.save(unit));
    }

    private static void update(UnitDto dto, Unit entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setDepartmentId(dto.getDepartment().getId());
    }

    @Override
    protected CrudRepository<Unit, String> getRepository() {
        return unitRepository;
    }
}
