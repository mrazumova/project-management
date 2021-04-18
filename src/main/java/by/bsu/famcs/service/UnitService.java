package by.bsu.famcs.service;

import by.bsu.famcs.dto.UnitDto;
import by.bsu.famcs.filter.UnitFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService extends CrudService<UnitDto> {

    Page<UnitDto> findAll(UnitFilter filter, Pageable pageable);
}
