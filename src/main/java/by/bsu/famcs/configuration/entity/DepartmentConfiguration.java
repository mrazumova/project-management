package by.bsu.famcs.configuration.entity;

import by.bsu.famcs.dto.DepartmentDto;
import by.bsu.famcs.entity.Department;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.mapper.impl.DepartmentMapper;
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
    public AbstractMapper<Department, DepartmentDto> departmentMapper() {
        return new DepartmentMapper();
    }

    @Bean
    public DepartmentService departmentService(AbstractMapper<Department, DepartmentDto> departmentMapper) {
        return new DepartmentServiceImpl(departmentRepository, departmentMapper);
    }
}
