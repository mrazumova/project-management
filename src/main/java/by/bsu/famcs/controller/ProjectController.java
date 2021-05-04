package by.bsu.famcs.controller;

import by.bsu.famcs.dto.ProjectDto;
import by.bsu.famcs.filter.ProjectFilter;
import by.bsu.famcs.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static by.bsu.famcs.security.SecurityPermission.EDIT_DATA;
import static by.bsu.famcs.security.SecurityPermission.READ_DATA;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private static final String PROJECT_ID_PARAM = "{projectId}";

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Secured(READ_DATA)
    @GetMapping
    public Page<ProjectDto> getAllProjects(ProjectFilter filter, Pageable pageable) {
        return projectService.findAll(filter, pageable);
    }

    @Secured(READ_DATA)
    @GetMapping(PROJECT_ID_PARAM)
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable String projectId) {
        return ResponseEntity.of(projectService.findById(projectId));
    }

    @Secured(EDIT_DATA)
    @PostMapping
    public ProjectDto createProject(@RequestBody ProjectDto project) {
        return projectService.create(project);
    }

    @Secured(EDIT_DATA)
    @PutMapping(PROJECT_ID_PARAM)
    public ProjectDto updateAnnotation(@RequestBody ProjectDto project, @PathVariable String projectId) {
        return projectService.update(project, projectId);
    }

    @Secured(EDIT_DATA)
    @DeleteMapping(PROJECT_ID_PARAM)
    public void removeProject(@PathVariable String projectId) {
        projectService.deleteById(projectId);
    }

}
