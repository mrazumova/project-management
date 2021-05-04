package by.bsu.famcs.controller;

import by.bsu.famcs.dto.DeveloperDto;
import by.bsu.famcs.filter.DeveloperFilter;
import by.bsu.famcs.service.DeveloperService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static by.bsu.famcs.security.SecurityPermission.EDIT_DATA;
import static by.bsu.famcs.security.SecurityPermission.READ_DATA;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private static final String DEVELOPER_ID_PARAM = "{developerId}";

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @Secured(READ_DATA)
    @GetMapping
    public Page<DeveloperDto> getAllDevelopers(DeveloperFilter filter, Pageable pageable) {
        return developerService.findAll(filter, pageable);
    }

    @Secured(READ_DATA)
    @GetMapping(DEVELOPER_ID_PARAM)
    public ResponseEntity<DeveloperDto> getDeveloperById(@PathVariable String developerId) {
        return ResponseEntity.of(developerService.findById(developerId));
    }

    @Secured(EDIT_DATA)
    @PostMapping
    public DeveloperDto createDeveloper(@RequestBody DeveloperDto developer) {
        return developerService.create(developer);
    }

    @Secured(EDIT_DATA)
    @PutMapping(DEVELOPER_ID_PARAM)
    public DeveloperDto updateDeveloper(@RequestBody DeveloperDto developer, @PathVariable String developerId) {
        return developerService.update(developer, developerId);
    }

    @Secured(EDIT_DATA)
    @DeleteMapping(DEVELOPER_ID_PARAM)
    public void removeDeveloper(@PathVariable String developerId) {
        developerService.deleteById(developerId);
    }

}
