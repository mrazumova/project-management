package by.bsu.famcs.controller;

import by.bsu.famcs.entity.Unit;
import by.bsu.famcs.filter.UnitFilter;
import by.bsu.famcs.service.UnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/units")
public class UnitController {

    private static final String UNIT_ID_PARAM = "{unitId}";

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public Page<Unit> getAllUnits(UnitFilter filter, Pageable pageable) {
        return unitService.findAll(filter, pageable);
    }

    @GetMapping(UNIT_ID_PARAM)
    public ResponseEntity<Unit> getUnitById(@PathVariable String unitId) {
        return ResponseEntity.of(unitService.findById(unitId));
    }

    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.create(unit);
    }

    @PutMapping(UNIT_ID_PARAM)
    public Unit updateAnnotation(@RequestBody Unit unit, @PathVariable String unitId) {
        return unitService.update(unit, unitId);
    }

    @DeleteMapping(UNIT_ID_PARAM)
    public void removeUnit(@PathVariable String unitId) {
        unitService.deleteById(unitId);
    }

}
