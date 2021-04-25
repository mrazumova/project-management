package by.bsu.famcs.controller;

import by.bsu.famcs.dto.DepartmentDto;
import by.bsu.famcs.filter.DepartmentFilter;
import by.bsu.famcs.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private static final String DEPARTMENT_ID_PARAM = "{departmentId}";

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public Page<DepartmentDto> getAllDepartments(DepartmentFilter filter, Pageable pageable) {
        return departmentService.findAll(filter, pageable);
    }

    @GetMapping(DEPARTMENT_ID_PARAM)
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String departmentId) {
        return ResponseEntity.of(departmentService.findById(departmentId));
    }

    @PostMapping
    public DepartmentDto createDepartment(@RequestBody DepartmentDto department) {
        return departmentService.create(department);
    }

    @PutMapping(DEPARTMENT_ID_PARAM)
    public DepartmentDto updateDepartment(@RequestBody DepartmentDto department, @PathVariable String departmentId) {
        return departmentService.update(department, departmentId);
    }

    @DeleteMapping(DEPARTMENT_ID_PARAM)
    public void removeDepartment(@PathVariable String departmentId) {
        departmentService.deleteById(departmentId);
    }

}
