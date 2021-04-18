package by.bsu.famcs.dto;

public class UnitDto {

    private String id;

    private String name;

    private String description;

    private DepartmentDto department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }
}
