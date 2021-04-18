package by.bsu.famcs.dto;

import by.bsu.famcs.entity.Level;
import by.bsu.famcs.entity.Specialization;

public class DeveloperDto {

    private String id;

    private String surname;

    private String name;

    private Specialization specialization;

    private Level level;

    private String cvLink;

    private int workload;

    private int salary;

    private ProjectDto project;

    private UnitDto unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getCvLink() {
        return cvLink;
    }

    public void setCvLink(String cvLink) {
        this.cvLink = cvLink;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

    public UnitDto getUnit() {
        return unit;
    }

    public void setUnit(UnitDto unit) {
        this.unit = unit;
    }
}
