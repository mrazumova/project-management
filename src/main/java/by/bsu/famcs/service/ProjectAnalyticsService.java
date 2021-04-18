package by.bsu.famcs.service;

import by.bsu.famcs.dto.ProjectAnalyticsDto;
import by.bsu.famcs.filter.ProjectAnalyticsFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectAnalyticsService extends CrudService<ProjectAnalyticsDto> {

    Page<ProjectAnalyticsDto> findAll(ProjectAnalyticsFilter filter, Pageable pageable);
}
