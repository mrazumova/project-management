package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.filter.UnitFilter;
import by.bsu.famcs.repository.UnitRepository;
import by.bsu.famcs.service.UnitService;
import by.bsu.famcs.specification.UnitSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class UnitServiceImpl extends DefaultCrudService<Unit> implements UnitService {

    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Page<Unit> findAll(UnitFilter filter, Pageable pageable) {
        return unitRepository.findAll(new UnitSpecification(filter), pageable);
    }

    @Override
    public Unit update(Unit entity, String entityId) {
        Unit unit = getEntity(entityId);
        update(entity, unit);
        return unitRepository.save(unit);
    }

    private static void update(Unit entity, Unit toUpdate) {
        toUpdate.setName(entity.getName());
        toUpdate.setDescription(entity.getDescription());
        toUpdate.setDepartment(entity.getDepartment());
        toUpdate.setManager(entity.getManager());
    }

    @Override
    protected CrudRepository<Unit, String> getRepository() {
        return unitRepository;
    }
}
