package by.bsu.famcs.mapper.impl;

import by.bsu.famcs.dto.DepartmentDto;
import by.bsu.famcs.entity.Department;

public class DepartmentMapper extends DefaultMapper<Department, DepartmentDto> {

    public DepartmentMapper() {
        super(Department.class, DepartmentDto.class);
    }

}
