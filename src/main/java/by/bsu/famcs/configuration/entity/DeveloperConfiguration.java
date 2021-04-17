package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.DeveloperRepository;
import by.bsu.famcs.service.DeveloperService;
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
    public DeveloperService developerService() {
        return new DeveloperServiceImpl(developerRepository);
    }
}
