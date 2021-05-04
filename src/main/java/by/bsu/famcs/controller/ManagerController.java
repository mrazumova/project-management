package by.bsu.famcs.controller;

import by.bsu.famcs.dto.ManagerDto;
import by.bsu.famcs.filter.ManagerFilter;
import by.bsu.famcs.service.ManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static by.bsu.famcs.security.SecurityPermission.EDIT_DATA;
import static by.bsu.famcs.security.SecurityPermission.READ_DATA;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    private static final String MANAGER_ID_PARAM = "{managerId}";

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Secured(READ_DATA)
    @GetMapping
    public Page<ManagerDto> getAllManagers(ManagerFilter filter, Pageable pageable) {
        return managerService.findAll(filter, pageable);
    }

    @Secured(READ_DATA)
    @GetMapping(MANAGER_ID_PARAM)
    public ResponseEntity<ManagerDto> getManagerById(@PathVariable String managerId) {
        return ResponseEntity.of(managerService.findById(managerId));
    }

    @Secured(EDIT_DATA)
    @PostMapping
    public ManagerDto createManager(@RequestBody ManagerDto manager) {
        return managerService.create(manager);
    }

    @Secured(EDIT_DATA)
    @PutMapping(MANAGER_ID_PARAM)
    public ManagerDto updateManager(@RequestBody ManagerDto manager, @PathVariable String managerId) {
        return managerService.update(manager, managerId);
    }

    @Secured(EDIT_DATA)
    @DeleteMapping(MANAGER_ID_PARAM)
    public void removeManager(@PathVariable String managerId) {
        managerService.deleteById(managerId);
    }
}
