package by.bsu.famcs.service;

import by.bsu.famcs.entity.Developer;
import by.bsu.famcs.filter.DeveloperFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeveloperService extends CrudService<Developer> {

    Page<Developer> findAll(DeveloperFilter filter, Pageable pageable);
}
