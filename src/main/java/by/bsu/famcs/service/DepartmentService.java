package by.bsu.famcs.service;

import by.bsu.famcs.dto.DepartmentDto;
import by.bsu.famcs.filter.DepartmentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService extends CrudService<DepartmentDto> {

    Page<DepartmentDto> findAll(DepartmentFilter filter, Pageable pageable);
}
