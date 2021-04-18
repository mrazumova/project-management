package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.ManagerDto;
import by.bsu.famcs.entity.Manager;
import by.bsu.famcs.filter.ManagerFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.ManagerRepository;
import by.bsu.famcs.service.ManagerService;
import by.bsu.famcs.specification.ManagerSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ManagerServiceImpl extends DefaultCrudService<Manager, ManagerDto> implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository, AbstractMapper<Manager, ManagerDto> mapper) {
        super(mapper);
        this.managerRepository = managerRepository;
    }

    @Override
    public Page<ManagerDto> findAll(ManagerFilter filter, Pageable pageable) {
        return managerRepository.findAll(new ManagerSpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public ManagerDto update(ManagerDto dto, String entityId) {
        Manager manager = getEntity(entityId);
        update(dto, manager);
        return mapper.toDto(managerRepository.save(manager));
    }

    private static void update(ManagerDto dto, Manager entity) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setPost(dto.getPost());
        entity.setWorkload(dto.getWorkload());
        entity.setCvLink(dto.getCvLink());
        entity.setSalary(dto.getSalary());
        entity.setUnitId(dto.getUnit().getId());
    }

    @Override
    protected CrudRepository<Manager, String> getRepository() {
        return managerRepository;
    }
}
