package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.DeveloperDto;
import by.bsu.famcs.entity.Developer;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.DeveloperMapper;
import by.bsu.famcs.repository.DeveloperRepository;
import by.bsu.famcs.service.DeveloperService;
import by.bsu.famcs.service.ProjectService;
import by.bsu.famcs.service.UnitService;
import by.bsu.famcs.service.impl.DeveloperServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeveloperConfiguration {

    private final DeveloperRepository developerRepository;

    public DeveloperConfiguration(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Bean
    public AbstractMapper<Developer, DeveloperDto> developerMapper(UnitService unitService, ProjectService projectService) {
        return new DeveloperMapper(unitService, projectService);
    }

    @Bean
    public DeveloperService developerService(AbstractMapper<Developer, DeveloperDto> developerMapper) {
        return new DeveloperServiceImpl(developerRepository, developerMapper);
    }
}
