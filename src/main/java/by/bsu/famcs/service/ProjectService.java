package by.bsu.famcs.service;

import by.bsu.famcs.dto.ProjectDto;
import by.bsu.famcs.filter.ProjectFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectService extends CrudService<ProjectDto> {

    Page<ProjectDto> findAll(ProjectFilter filter, Pageable pageable);
}
