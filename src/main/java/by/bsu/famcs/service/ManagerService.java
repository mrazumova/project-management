package by.bsu.famcs.service;

import by.bsu.famcs.entity.Manager;
import by.bsu.famcs.filter.ManagerFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService extends CrudService<Manager> {

    Page<Manager> findAll(ManagerFilter filter, Pageable pageable);
}
