package by.bsu.famcs.service;

import by.bsu.famcs.entity.Project;
import by.bsu.famcs.filter.ProjectFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService extends CrudService<Project> {

    Page<Project> findAll(ProjectFilter filter, Pageable pageable);
}
