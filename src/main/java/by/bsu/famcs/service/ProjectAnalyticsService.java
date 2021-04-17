package by.bsu.famcs.service;

import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.filter.ProjectAnalyticsFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProjectAnalyticsService extends CrudService<ProjectAnalytics> {

    Page<ProjectAnalytics> findAll(ProjectAnalyticsFilter filter, Pageable pageable);
}
