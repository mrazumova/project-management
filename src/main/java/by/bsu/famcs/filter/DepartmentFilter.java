package by.bsu.famcs.filter;

import by.bsu.famcs.entity.Manager;

public class DepartmentFilter {

    private String name;

    private Manager manager;

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
}
