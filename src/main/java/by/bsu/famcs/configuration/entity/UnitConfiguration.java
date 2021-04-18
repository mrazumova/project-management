package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.UnitDto;
import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.UnitMapper;
import by.bsu.famcs.repository.UnitRepository;
import by.bsu.famcs.service.DepartmentService;
import by.bsu.famcs.service.UnitService;
import by.bsu.famcs.service.impl.UnitServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnitConfiguration {

    private final UnitRepository unitRepository;

    public UnitConfiguration(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Bean
    public AbstractMapper<Unit, UnitDto> unitMapper(DepartmentService departmentService) {
        return new UnitMapper(departmentService);
    }

    @Bean
    public UnitService unitService(AbstractMapper<Unit, UnitDto> unitMapper) {
        return new UnitServiceImpl(unitRepository, unitMapper);
    }
}
