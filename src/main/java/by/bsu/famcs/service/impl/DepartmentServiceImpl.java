package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.Department;
import by.bsu.famcs.filter.DepartmentFilter;
import by.bsu.famcs.repository.DepartmentRepository;
import by.bsu.famcs.service.DepartmentService;
import by.bsu.famcs.specification.DepartmentSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class DepartmentServiceImpl extends DefaultCrudService<Department> implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Page<Department> findAll(DepartmentFilter filter, Pageable pageable) {
        return departmentRepository.findAll(new DepartmentSpecification(filter), pageable);
    }

    @Override
    public Department update(Department entity, String entityId) {
        Department department = getEntity(entityId);
        update(entity, department);
        return departmentRepository.save(department);
    }

    private static void update(Department entity, Department toUpdate) {
        toUpdate.setName(entity.getName());
        toUpdate.setDescription(entity.getDescription());
        toUpdate.setManager(entity.getManager());
    }

    @Override
    protected CrudRepository<Department, String> getRepository() {
        return departmentRepository;
    }
}
