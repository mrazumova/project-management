package by.bsu.famcs.service;

import by.bsu.famcs.dto.DeveloperDto;
import by.bsu.famcs.filter.DeveloperFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeveloperService extends CrudService<DeveloperDto> {

    Page<DeveloperDto> findAll(DeveloperFilter filter, Pageable pageable);
}
