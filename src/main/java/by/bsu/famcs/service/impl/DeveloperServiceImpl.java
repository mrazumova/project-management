package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.DeveloperDto;
import by.bsu.famcs.entity.Developer;
import by.bsu.famcs.filter.DeveloperFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.DeveloperRepository;
import by.bsu.famcs.service.DeveloperService;
import by.bsu.famcs.specification.DeveloperSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class DeveloperServiceImpl extends DefaultCrudService<Developer, DeveloperDto> implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository, AbstractMapper<Developer, DeveloperDto> mapper) {
        super(mapper);
        this.developerRepository = developerRepository;
    }

    @Override
    public Page<DeveloperDto> findAll(DeveloperFilter filter, Pageable pageable) {
        return developerRepository.findAll(new DeveloperSpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public DeveloperDto update(DeveloperDto dto, String entityId) {
        Developer developer = getEntity(entityId);
        update(dto, developer);
        return mapper.toDto(developerRepository.save(developer));
    }

    private static void update(DeveloperDto dto, Developer entity) {
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setSpecialization(dto.getSpecialization());
        entity.setLevel(dto.getLevel());
        entity.setSalary(dto.getSalary());
        entity.setWorkload(dto.getWorkload());
        entity.setProjectId(dto.getProject().getId());
        entity.setCvLink(dto.getCvLink());
        entity.setUnitId(dto.getUnit().getId());
    }

    @Override
    protected CrudRepository<Developer, String> getRepository() {
        return developerRepository;
    }
}
