package by.bsu.famcs.filter;

import by.bsu.famcs.entity.Department;
import by.bsu.famcs.entity.Manager;

public class UnitFilter {

    private String name;

    private Manager manager;

    private Department department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
