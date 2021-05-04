package by.bsu.famcs.controller;

import by.bsu.famcs.dto.DepartmentDto;
import by.bsu.famcs.filter.DepartmentFilter;
import by.bsu.famcs.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static by.bsu.famcs.security.SecurityPermission.EDIT_DATA;
import static by.bsu.famcs.security.SecurityPermission.READ_DATA;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private static final String DEPARTMENT_ID_PARAM = "{departmentId}";

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Secured(READ_DATA)
    @GetMapping
    public Page<DepartmentDto> getAllDepartments(DepartmentFilter filter, Pageable pageable) {
        return departmentService.findAll(filter, pageable);
    }

    @Secured(READ_DATA)
    @GetMapping(DEPARTMENT_ID_PARAM)
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String departmentId) {
        return ResponseEntity.of(departmentService.findById(departmentId));
    }

    @Secured(EDIT_DATA)
    @PostMapping
    public DepartmentDto createDepartment(@RequestBody DepartmentDto department) {
        return departmentService.create(department);
    }

    @Secured(EDIT_DATA)
    @PutMapping(DEPARTMENT_ID_PARAM)
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto department, @PathVariable String departmentId) {
        return departmentService.update(department, departmentId);
    }

    @Secured(EDIT_DATA)
    @DeleteMapping(DEPARTMENT_ID_PARAM)
    public void removeDepartment(@PathVariable String departmentId) {
        departmentService.deleteById(departmentId);
    }

}
