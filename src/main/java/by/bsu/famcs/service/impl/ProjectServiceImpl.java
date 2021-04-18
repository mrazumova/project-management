package by.bsu.famcs.service.impl;

import by.bsu.famcs.dto.ProjectDto;
import by.bsu.famcs.entity.Project;
import by.bsu.famcs.filter.ProjectFilter;
import by.bsu.famcs.mapper.AbstractMapper;
import by.bsu.famcs.repository.ProjectRepository;
import by.bsu.famcs.service.ProjectService;
import by.bsu.famcs.specification.ProjectSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public class ProjectServiceImpl extends DefaultCrudService<Project, ProjectDto> implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, AbstractMapper<Project, ProjectDto> mapper) {
        super(mapper);
        this.projectRepository = projectRepository;
    }

    @Override
    public Page<ProjectDto> findAll(ProjectFilter filter, Pageable pageable) {
        return projectRepository.findAll(new ProjectSpecification(filter), pageable).map(mapper::toDto);
    }

    @Override
    public ProjectDto update(ProjectDto dto, String entityId) {
        Project project = getEntity(entityId);
        update(dto, project);
        return mapper.toDto(projectRepository.save(project));
    }

    private static void update(ProjectDto dto, Project entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setManagerId(dto.getManager().getId());
        entity.setPricingModel(dto.getPricingModel());
        entity.setType(dto.getType());
        entity.setStatus(dto.getStatus());
        entity.setStarted(dto.getStarted());
        entity.setFinished(dto.getFinished());
        entity.setSupportType(dto.getSupportType());
    }

    @Override
    protected CrudRepository<Project, String> getRepository() {
        return projectRepository;
    }
}
