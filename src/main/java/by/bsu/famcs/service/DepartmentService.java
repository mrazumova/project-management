package by.bsu.famcs.service;

import by.bsu.famcs.entity.Department;
import by.bsu.famcs.filter.DepartmentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService extends CrudService<Department> {

    Page<Department> findAll(DepartmentFilter filter, Pageable pageable);
}
