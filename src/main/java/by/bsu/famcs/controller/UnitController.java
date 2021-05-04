package by.bsu.famcs.controller;

import by.bsu.famcs.dto.UnitDto;
import by.bsu.famcs.filter.UnitFilter;
import by.bsu.famcs.service.UnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static by.bsu.famcs.security.SecurityPermission.EDIT_DATA;
import static by.bsu.famcs.security.SecurityPermission.READ_DATA;

@RestController
@RequestMapping("/units")
public class UnitController {

    private static final String UNIT_ID_PARAM = "{unitId}";

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @Secured(READ_DATA)
    @GetMapping
    public Page<UnitDto> getAllUnits(UnitFilter filter, Pageable pageable) {
        return unitService.findAll(filter, pageable);
    }

    @Secured(READ_DATA)
    @GetMapping(UNIT_ID_PARAM)
    public ResponseEntity<UnitDto> getUnitById(@PathVariable String unitId) {
        return ResponseEntity.of(unitService.findById(unitId));
    }

    @Secured(EDIT_DATA)
    @PostMapping
    public UnitDto createUnit(@RequestBody UnitDto unit) {
        return unitService.create(unit);
    }

    @Secured(EDIT_DATA)
    @PutMapping(UNIT_ID_PARAM)
    public UnitDto updateAnnotation(@RequestBody UnitDto unit, @PathVariable String unitId) {
        return unitService.update(unit, unitId);
    }

    @Secured(EDIT_DATA)
    @DeleteMapping(UNIT_ID_PARAM)
    public void removeUnit(@PathVariable String unitId) {
        unitService.deleteById(unitId);
    }

}
