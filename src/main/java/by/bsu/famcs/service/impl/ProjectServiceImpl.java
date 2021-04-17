package by.bsu.famcs.service.impl;

import by.bsu.famcs.entity.Project;
import by.bsu.famcs.filter.ProjectFilter;
import by.bsu.famcs.repository.ProjectRepository;
import by.bsu.famcs.service.ProjectService;
import by.bsu.famcs.specification.ProjectSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ProjectServiceImpl extends DefaultCrudService<Project> implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Page<Project> findAll(ProjectFilter filter, Pageable pageable) {
        return projectRepository.findAll(new ProjectSpecification(filter), pageable);
    }

    @Override
    public Project update(Project entity, String entityId) {
        Project project = getEntity(entityId);
        update(entity, project);
        return projectRepository.save(project);
    }

    private static void update(Project entity, Project toUpdate) {
        toUpdate.setName(entity.getName());
        toUpdate.setDescription(entity.getDescription());
        toUpdate.setManager(entity.getManager());
        toUpdate.setPricingModel(entity.getPricingModel());
        toUpdate.setType(entity.getType());
        toUpdate.setStatus(entity.getStatus());
        toUpdate.setStarted(entity.getStarted());
        toUpdate.setFinished(entity.getFinished());
        toUpdate.setSupportType(entity.getSupportType());
    }

    @Override
    protected CrudRepository<Project, String> getRepository() {
        return projectRepository;
    }
}
