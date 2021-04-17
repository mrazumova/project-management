package by.bsu.famcs.service;

import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.filter.UnitFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitService extends CrudService<Unit> {

    Page<Unit> findAll(UnitFilter filter, Pageable pageable);
}
