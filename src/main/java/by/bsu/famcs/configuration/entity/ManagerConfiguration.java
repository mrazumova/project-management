package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.ManagerRepository;
import by.bsu.famcs.service.ManagerService;
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
    public ManagerService managerService() {
        return new ManagerServiceImpl(managerRepository);
    }
}
