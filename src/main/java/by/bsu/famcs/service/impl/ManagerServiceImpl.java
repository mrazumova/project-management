package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.Manager;
import by.bsu.famcs.filter.ManagerFilter;
import by.bsu.famcs.repository.ManagerRepository;
import by.bsu.famcs.service.ManagerService;
import by.bsu.famcs.specification.ManagerSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ManagerServiceImpl extends DefaultCrudService<Manager> implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Page<Manager> findAll(ManagerFilter filter, Pageable pageable) {
        return managerRepository.findAll(new ManagerSpecification(filter), pageable);
    }

    @Override
    public Manager update(Manager entity, String entityId) {
        Manager manager = getEntity(entityId);
        update(entity, manager);
        return managerRepository.save(manager);
    }

    private static void update(Manager entity, Manager toUpdate) {
        toUpdate.setName(entity.getName());
        toUpdate.setSurname(entity.getSurname());
        toUpdate.setPost(entity.getPost());
        toUpdate.setWorkload(entity.getWorkload());
        toUpdate.setCvLink(entity.getCvLink());
        toUpdate.setSalary(entity.getSalary());
        toUpdate.setUnit(entity.getUnit());
    }

    @Override
    protected CrudRepository<Manager, String> getRepository() {
        return managerRepository;
    }
}
