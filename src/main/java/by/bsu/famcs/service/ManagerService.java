package by.bsu.famcs.service;

import by.bsu.famcs.dto.ManagerDto;
import by.bsu.famcs.filter.ManagerFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService extends CrudService<ManagerDto> {

    Page<ManagerDto> findAll(ManagerFilter filter, Pageable pageable);
}
