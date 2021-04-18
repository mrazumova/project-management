package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.DepartmentDto;
import by.bsu.famcs.entity.Department;
import by.bsu.famcs.filter.DepartmentFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.DepartmentRepository;
import by.bsu.famcs.service.DepartmentService;
import by.bsu.famcs.specification.DepartmentSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class DepartmentServiceImpl extends DefaultCrudService<Department, DepartmentDto> implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, AbstractMapper<Department, DepartmentDto> mapper) {
        super(mapper);
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Page<DepartmentDto> findAll(DepartmentFilter filter, Pageable pageable) {
        return departmentRepository.findAll(new DepartmentSpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public DepartmentDto update(DepartmentDto dto, String entityId) {
        Department department = getEntity(entityId);
        update(dto, department);
        return mapper.toDto(departmentRepository.save(department));
    }

    private static void update(DepartmentDto dto, Department entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
    }

    @Override
    protected CrudRepository<Department, String> getRepository() {
        return departmentRepository;
    }
}
