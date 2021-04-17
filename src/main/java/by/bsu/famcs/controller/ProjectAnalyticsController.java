package by.bsu.famcs.controller;

import by.bsu.famcs.entity.ProjectAnalytics;
import by.bsu.famcs.filter.ProjectAnalyticsFilter;
import by.bsu.famcs.service.ProjectAnalyticsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project-analytics")
public class ProjectAnalyticsController {

    private static final String PROJECT_ANALYTICS_ID_PARAM = "{projectAnalyticsId}";

    private final ProjectAnalyticsService projectAnalyticsService;

    public ProjectAnalyticsController(ProjectAnalyticsService projectAnalyticsService) {
        this.projectAnalyticsService = projectAnalyticsService;
    }

    @GetMapping
    public Page<ProjectAnalytics> getAllProjectAnalytics(ProjectAnalyticsFilter filter, Pageable pageable) {
        return projectAnalyticsService.findAll(filter, pageable);
    }

    @GetMapping(PROJECT_ANALYTICS_ID_PARAM)
    public ResponseEntity<ProjectAnalytics> getProjectAnalyticsById(@PathVariable String projectAnalyticsId) {
        return ResponseEntity.of(projectAnalyticsService.findById(projectAnalyticsId));
    }

    @PostMapping
    public ProjectAnalytics createProjectAnalytics(@RequestBody ProjectAnalytics projectAnalytics) {
        return projectAnalyticsService.create(projectAnalytics);
    }

    @PutMapping(PROJECT_ANALYTICS_ID_PARAM)
    public ProjectAnalytics updateAnnotation(@RequestBody ProjectAnalytics projectAnalytics, @PathVariable String projectAnalyticsId) {
        return projectAnalyticsService.update(projectAnalytics, projectAnalyticsId);
    }

    @DeleteMapping(PROJECT_ANALYTICS_ID_PARAM)
    public void removeProjectAnalytics(@PathVariable String projectAnalyticsId) {
        projectAnalyticsService.deleteById(projectAnalyticsId);
    }

}
