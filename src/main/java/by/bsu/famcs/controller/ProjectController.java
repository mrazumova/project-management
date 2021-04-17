package by.bsu.famcs.controller;

import by.bsu.famcs.entity.Project;
import by.bsu.famcs.filter.ProjectFilter;
import by.bsu.famcs.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    private static final String PROJECT_ID_PARAM = "{projectId}";

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public Page<Project> getAllProjects(ProjectFilter filter, Pageable pageable) {
        return projectService.findAll(filter, pageable);
    }

    @GetMapping(PROJECT_ID_PARAM)
    public ResponseEntity<Project> getProjectById(@PathVariable String projectId) {
        return ResponseEntity.of(projectService.findById(projectId));
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.create(project);
    }

    @PutMapping(PROJECT_ID_PARAM)
    public Project updateAnnotation(@RequestBody Project project, @PathVariable String projectId) {
        return projectService.update(project, projectId);
    }

    @DeleteMapping(PROJECT_ID_PARAM)
    public void removeProject(@PathVariable String projectId) {
        projectService.deleteById(projectId);
    }

}
