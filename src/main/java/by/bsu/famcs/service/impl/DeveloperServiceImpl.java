package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.Developer;
import by.bsu.famcs.filter.DeveloperFilter;
import by.bsu.famcs.repository.DeveloperRepository;
import by.bsu.famcs.service.DeveloperService;
import by.bsu.famcs.specification.DeveloperSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class DeveloperServiceImpl extends DefaultCrudService<Developer> implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public Page<Developer> findAll(DeveloperFilter filter, Pageable pageable) {
        return developerRepository.findAll(new DeveloperSpecification(filter), pageable);
    }

    @Override
    public Developer update(Developer entity, String entityId) {
        Developer developer = getEntity(entityId);
        update(entity, developer);
        return developerRepository.save(developer);
    }

    private static void update(Developer entity, Developer toUpdate) {
        toUpdate.setName(entity.getName());
        toUpdate.setSurname(entity.getSurname());
        toUpdate.setSpecialization(entity.getSpecialization());
        toUpdate.setLevel(entity.getLevel());
        toUpdate.setSalary(entity.getSalary());
        toUpdate.setWorkload(entity.getWorkload());
        toUpdate.setProject(entity.getProject());
        toUpdate.setCvLink(entity.getCvLink());
        toUpdate.setUnit(entity.getUnit());
    }

    @Override
    protected CrudRepository<Developer, String> getRepository() {
        return developerRepository;
    }
}
