package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.repository.DepartmentRepository;
import by.bsu.famcs.service.DepartmentService;
import by.bsu.famcs.service.impl.DepartmentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfiguration {

    private final DepartmentRepository departmentRepository;

    public DepartmentConfiguration(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Bean
    public DepartmentService departmentService() {
        return new DepartmentServiceImpl(departmentRepository);
    }
}
