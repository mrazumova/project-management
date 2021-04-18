package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.ManagerDto;
import by.bsu.famcs.entity.Manager;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.ManagerMapper;
import by.bsu.famcs.repository.ManagerRepository;
import by.bsu.famcs.service.ManagerService;
import by.bsu.famcs.service.UnitService;
import by.bsu.famcs.service.impl.ManagerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagerConfiguration {

    private final ManagerRepository managerRepository;

    public ManagerConfiguration(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Bean
    public AbstractMapper<Manager, ManagerDto> managerMapper(UnitService unitService) {
        return new ManagerMapper(unitService);
    }

    @Bean
    public ManagerService managerService(AbstractMapper<Manager, ManagerDto> managerMapper) {
        return new ManagerServiceImpl(managerRepository, managerMapper);
    }
}
