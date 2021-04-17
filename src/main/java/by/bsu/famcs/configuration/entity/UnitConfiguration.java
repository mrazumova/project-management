package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.UnitRepository;
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
    public UnitService unitService() {
        return new UnitServiceImpl(unitRepository);
    }
}
